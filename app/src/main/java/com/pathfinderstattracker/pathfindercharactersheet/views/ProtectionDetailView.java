package com.pathfinderstattracker.pathfindercharactersheet.views;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmorEnchantment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IProtection;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IShield;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWeaponEnchantment;

import java.util.List;

/**
 * TODO: document your custom view class.
 */
public class ProtectionDetailView extends ConstraintLayout
{

    private TextView magicBonus;
    private TextView equipmentAbilities;
    private TextView equipmentName;
    private TextView equipmentWeightCategory;
    private TextView checkPenalty;
    private TextView maxDex;
    private TextView spellFailure;
    private TextView weight;

    public ProtectionDetailView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initializeViews(context);
    }

    private void initializeViews(Context context)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.protection_detail_view, this);
    }

    protected void onFinishInflate()
{
    super.onFinishInflate();
    magicBonus = this.findViewById(R.id.MagicBonusDropdown);
    equipmentAbilities = this.findViewById(R.id.EquipmentAbilitiesDropdown);
    equipmentName = this.findViewById(R.id.EquipmentNameDropdown);
    equipmentWeightCategory= this.findViewById(R.id.WeightCategoryDropdown);
    checkPenalty = this.findViewById(R.id.CheckPenaltyDropdown);
    maxDex = this.findViewById(R.id.MaxDexDropdown);
    spellFailure = this.findViewById(R.id.SpellFailureDropdown);
    weight = this.findViewById(R.id.WeightDropdown);
}

    public void setValues(IProtection protectionItem)
    {
        this.magicBonus.setText(String.format("+%s ", Integer.toString(protectionItem.getMagicBonus())));
        this.equipmentName.setText(protectionItem.getName());
        if(protectionItem instanceof IShield)
        {
            this.equipmentWeightCategory.setText(((IShield)protectionItem).getWeightCategory().toString());
            this.equipmentAbilities.setText(CreateEnchantmentString((IShield)protectionItem));
        }
        else if(protectionItem instanceof IArmor)
        {
            this.equipmentWeightCategory.setText(((IArmor)protectionItem).getWeightCategory().toString());
            this.equipmentAbilities.setText(CreateEnchantmentString((IArmor) protectionItem));
        }
        this.checkPenalty.setText(String.format("-%s", Integer.toString(protectionItem.getArmorCheckPenalty())));
        this.maxDex.setText(Integer.toString(protectionItem.getMaximumDexBonus()));
        this.spellFailure.setText(String.format("%s%%", Integer.toString(protectionItem.getArcaneSpellFailureChance())));
        this.weight.setText(String.format("%s lbs", Double.toString(protectionItem.getCurrentWeight())));
    }

    private String CreateEnchantmentString(IArmor armor)
    {
        List<IArmorEnchantment> enchantments = armor.getEnchantments();
        StringBuilder enchantmentString = new StringBuilder();
        if(enchantments != null && enchantments.size() >= 1) {
            for (IArmorEnchantment enchantment : enchantments) {
                enchantmentString.append(enchantment.getName()).append(" ");
            }
            return enchantmentString.toString();
        }
        else
        {
            return "None";
        }
    }

    private String CreateEnchantmentString(IShield shield)
    {
        List<IWeaponEnchantment> enchantments = shield.getEnchantments();
        StringBuilder enchantmentString = new StringBuilder();
        if(shield.getEnchantments() != null && enchantments.size() >= 1) {
            for (IWeaponEnchantment enchantment : enchantments) {
                enchantmentString.append(enchantment.getName()).append(" ");
            }
            return enchantmentString.toString();
        }
        else
        {
            return "None";
        }
    }
}
