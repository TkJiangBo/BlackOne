package ThMod.powers.BlackOne;

import ThMod.cards.BlackOne.月牙天冲;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class 卍解P extends AbstractPower {
    public static final String POWER_ID = "卍解_Power";
    public static final String NAME = "卍解";
    public static final String DESCRIPTION = "回合开始时加入1张月牙冲天到手牌。";

    public 卍解P(AbstractCreature owner, int amount) {
        this.ID = POWER_ID;
        this.name = NAME;
        this.owner = owner;
        this.amount = amount;
        this.type = AbstractPower.PowerType.BUFF;
        this.description = DESCRIPTION;
        this.img = new Texture("img/powers/drawCardRed.png");
    }

    public void atStartOfTurnPostDraw() {
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(new 月牙天冲(), amount));
    }
}
