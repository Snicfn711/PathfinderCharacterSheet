package com.pathfinderstattracker.pathfindercharactersheet.views;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWeapon;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWeaponEnchantment;

import java.util.List;

public class WeaponDetailView extends ConstraintLayout
{
    private TextView magicBonus;
    private TextView equipmentAbilities;
    private TextView equipmentName;
    private TextView equipmentCritical;
    private TextView damageTypes;
    private TextView equipmentRange;
    private TextView equipmentDamage;

    public WeaponDetailView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initializeViews(context);
    }

    private void initializeViews(Context context)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.weapon_detail_view, this);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        magicBonus = this.findViewById(R.id.MagicBonusDropdown);
        equipmentAbilities = this.findViewById(R.id.EquipmentAbilitiesDropdown);
        equipmentName = this.findViewById(R.id.EquipmentNameDropdown);
        equipmentCritical= this.findViewById(R.id.EquipmentCriticalDropdown);
        damageTypes = this.findViewById(R.id.DamageTypeDropdown);
        equipmentRange = this.findViewById(R.id.EquipmentRangeDropdown);
        equipmentDamage = this.findViewById(R.id.EquipmentDamageDropdown);
    }

    public void setValues(IWeapon weapon)
    {
        this.magicBonus.setText(String.format("+%s ", Integer.toString(weapon.getMagicBonus())));
        this.equipmentAbilities.setText(CreateEnchantmentString(weapon));
        this.equipmentName.setText(weapon.getName());
        this.equipmentCritical.setText(weapon.returnCriticalString());
        this.damageTypes.setText(weapon.returnDamageTypes());
        this.equipmentRange.setText(Integer.toString(weapon.getRange()));
        this.equipmentDamage.setText(weapon.returnDamageDice());
    }

    private String CreateEnchantmentString(IWeapon weapon)
    {
        List<IWeaponEnchantment> enchantments = weapon.getEnchantments();
        StringBuilder enchantmentString = new StringBuilder();
        if(enchantments != null && enchantments.size() >= 1) {
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
