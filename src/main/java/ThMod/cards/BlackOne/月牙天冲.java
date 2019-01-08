package ThMod.cards.BlackOne;

import ThMod.action.SparkCostAction;
import ThMod.patches.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class 月牙天冲 extends CustomCard {
    public static final String ID = "yueyatianchong";
    public static final String NAME = "月牙天冲";
    public static final String DESCRIPTION = "对所有敌人造成 !D! 点伤害。";
    public static final String IMG_PATH = "img/cards/temp/DarkSpark.png";
    private static final int COST = 0;
    private static final int ATK_DMG = 5;
    private static final int UPG_DMG = 3;

    public 月牙天冲() {
        super(ID,
                NAME,
                IMG_PATH,
                COST,
                DESCRIPTION,
                CardType.ATTACK,
                AbstractCardEnum.MARISA_COLOR,
                CardRarity.UNCOMMON,
                CardTarget.ALL_ENEMY
        );
        this.baseDamage = ATK_DMG;
        this.isMultiDamage = true;
    }


    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        AbstractDungeon.actionManager.addToBottom(
                new DamageAllEnemiesAction(abstractPlayer,
                        this.multiDamage,
                        this.damageTypeForTurn,
                        AbstractGameAction.AttackEffect.BLUNT_LIGHT)
        );
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeDamage(UPG_DMG);
        }
    }
}
