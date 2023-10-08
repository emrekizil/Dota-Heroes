package com.example.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "dota_response_item_entity")
data class DotaResponseItemEntity(
    @PrimaryKey
    val id: Int,
    @SerializedName("agi_gain")
    val agiGain: Double,
    @SerializedName("attack_point")
    val attackPoint: Double,
    @SerializedName("attack_range")
    val attackRange: Int,
    @SerializedName("attack_rate")
    val attackRate: Double,
    @SerializedName("attack_type")
    val attackType: String,
    @SerializedName("base_agi")
    val baseAgi: Int,
    @SerializedName("base_armor")
    val baseArmor: Double,
    @SerializedName("base_attack_max")
    val baseAttackMax: Int,
    @SerializedName("base_attack_min")
    val baseAttackMin: Int,
    @SerializedName("base_attack_time")
    val baseAttackTime: Int,
    @SerializedName("base_health")
    val baseHealth: Int,
    @SerializedName("base_health_regen")
    val baseHealthRegen: Double,
    @SerializedName("base_mana")
    val baseMana: Int,
    @SerializedName("base_mana_regen")
    val baseManaRegen: Double,
    @SerializedName("base_mr")
    val baseMr: Int,
    @SerializedName("base_str")
    val baseStr: Int,
    @SerializedName("base_int")
    val baseInt: Int,
    @SerializedName("cm_enabled")
    val cmEnabled: Boolean,
    @SerializedName("day_vision")
    val dayVision: Int,
    @SerializedName("hero_id")
    val heroId: Int,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("img")
    val img: String,
    @SerializedName("int_gain")
    val intGain: Double,
    @SerializedName("legs")
    val legs: Int,
    @SerializedName("localized_name")
    val localizedName: String,
    @SerializedName("move_speed")
    val moveSpeed: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("night_vision")
    val nightVision: Int,
    @SerializedName("null_pick")
    val nullPick: Int,
    @SerializedName("null_win")
    val nullWin: Int,
    @SerializedName("1_pick")
    val pick1: Int,
    @SerializedName("2_pick")
    val pick2: Int,
    @SerializedName("3_pick")
    val pick3: Int,
    @SerializedName("4_pick")
    val pick4: Int,
    @SerializedName("5_pick")
    val pick5: Int,
    @SerializedName("6_pick")
    val pick6: Int,
    @SerializedName("7_pick")
    val pick7: Int,
    @SerializedName("8_pick")
    val pick8: Int,
    @SerializedName("primary_attr")
    val primaryAttr: String,
    @SerializedName("pro_ban")
    val proBan: Int,
    @SerializedName("pro_pick")
    val proPick: Int,
    @SerializedName("pro_win")
    val proWin: Int,
    @SerializedName("projectile_speed")
    val projectileSpeed: Int,
    @SerializedName("roles")
    val roles: List<String>,
    @SerializedName("str_gain")
    val strGain: Double,
    @SerializedName("turbo_picks")
    val turboPicks: Int,
    @SerializedName("turbo_wins")
    val turboWins: Int,
    @SerializedName("turn_rate")
    val turnRate: Double,
    @SerializedName("1_win")
    val win1: Int,
    @SerializedName("2_win")
    val win2: Int,
    @SerializedName("3_win")
    val win3: Int,
    @SerializedName("4_win")
    val win4: Int,
    @SerializedName("5_win")
    val win5: Int,
    @SerializedName("6_win")
    val win6: Int,
    @SerializedName("7_win")
    val win7: Int,
    @SerializedName("8_win")
    val win8: Int
)
