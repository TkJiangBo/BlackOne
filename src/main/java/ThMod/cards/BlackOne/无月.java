package ThMod.cards.BlackOne;

import ThMod.ThMod;
import ThMod.action.SparkCostAction;
import ThMod.patches.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.DaggerSprayEffect;
import com.megacrit.cardcrawl.vfx.combat.SweepingBeamEffect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class 无月 extends CustomCard {
    public static final Logger logger = LogManager.getLogger(ThMod.class.getName());
    public static final String ID = "wuyue";
    public static final String NAME = "无月";
    public static final String DESCRIPTION = "对所有敌人造成 !D! 点伤害 !M! 次。NL 消耗 。";
    public static final String IMG_PATH = "img/cards/temp/DarkSpark.png";

    private static final int COST = 3;
    private static final int ATTACK_DMG = 25;
    private static final int CNT = 4;

    private static final int UPG_CNT = 1;
    private static final int UPG_DMG = 5;

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
        }
        upgradeDamage(UPG_DMG);
        upgradeMagicNumber(UPG_CNT);
    }

    public 无月() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION,
                AbstractCard.CardType.ATTACK,
                AbstractCardEnum.MARISA_COLOR,
                AbstractCard.CardRarity.UNCOMMON,
                CardTarget.ALL_ENEMY
        );
        this.baseDamage = ATTACK_DMG;
        this.magicNumber = this.baseMagicNumber = CNT;
        this.isMultiDamage = true;
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        for (int i = 0; i < this.magicNumber; i++) {
            AbstractDungeon.actionManager.addToBottom(new SFXAction("ATTACK_DEFECT_BEAM"));
            AbstractDungeon.actionManager.addToBottom(new VFXAction(abstractPlayer, new SweepingBeamEffect(AbstractDungeon.player.hb.cX, AbstractDungeon.player.hb.cY, AbstractDungeon.player.flipHorizontal), 0.4F));
            AbstractDungeon.actionManager.addToBottom(new DamageAllEnemiesAction(abstractPlayer, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.FIRE));
        }
        logger.info("伤害是次数" + this.magicNumber);
    }
}
