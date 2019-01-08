package ThMod.cards.BlackOne;

import ThMod.patches.AbstractCardEnum;
import ThMod.powers.BlackOne.卍解P;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class 卍解 extends CustomCard {

    public static final String ID = "wanjie";
    public static final String NAME = "卍解";
    public static final String DESCRIPTION = "进入卍解状态,每回合开始加入 !M! 张月牙冲天到手牌。";
    public static final String IMG_PATH = "img/cards/temp/DarkSpark.png";
    private static final int COST = 1;
    private static final int MG = 1;
    private static final int UPG_MG = 2;

    public 卍解() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION,CardType.POWER,
                AbstractCardEnum.MARISA_COLOR,
                CardRarity.SPECIAL,
                CardTarget.SELF
        );
        this.magicNumber = this.baseMagicNumber = MG;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeMagicNumber(UPG_MG);
        }
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        AbstractDungeon.actionManager.addToBottom(
                new ApplyPowerAction(
                        abstractPlayer,
                        abstractPlayer,
                        new 卍解P(abstractPlayer, this.magicNumber),
                        this.magicNumber
                )
        );
    }
}
