package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package is responsible for modeling the energy consumers and the system load as curves and associated curve data.
 * Special circumstances that may affect the load, such as seasons and daytypes, are also included here.
 */

/**
 * ConformLoad represent loads that follow a daily load change pattern where the pattern can be used to scale the load with a system load.
 */
case class ConformLoad
(

    override val sup: EnergyConsumer,

    /**
     * Group of this ConformLoad.
     */
    val LoadGroup: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def EnergyConsumer: EnergyConsumer = sup.asInstanceOf[EnergyConsumer]
    override def copy (): Row = { return (clone ().asInstanceOf[ConformLoad]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConformLoad
extends
    Parseable[ConformLoad]
{
    val sup = EnergyConsumer.parse _
    val LoadGroup = parse_attribute (attribute ("""ConformLoad.LoadGroup"""))_
    def parse (context: Context): ConformLoad =
    {
        ConformLoad(
            sup (context),
            LoadGroup (context)
        )
    }
}

/**
 * A group of loads conforming to an allocation pattern.
 */
case class ConformLoadGroup
(

    override val sup: LoadGroup
)
extends
    Element
{
    def this () = { this (null) }
    def LoadGroup: LoadGroup = sup.asInstanceOf[LoadGroup]
    override def copy (): Row = { return (clone ().asInstanceOf[ConformLoadGroup]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConformLoadGroup
extends
    Parseable[ConformLoadGroup]
{
    val sup = LoadGroup.parse _
    def parse (context: Context): ConformLoadGroup =
    {
        ConformLoadGroup(
            sup (context)
        )
    }
}

/**
 * A curve of load  versus time (X-axis) showing the active power values (Y1-axis) and reactive power (Y2-axis) for each unit of the period covered.
 * This curve represents a typical pattern of load over the time period for a given day type and season.
 */
case class ConformLoadSchedule
(

    override val sup: SeasonDayTypeSchedule,

    /**
     * The ConformLoadGroup where the ConformLoadSchedule belongs.
     */
    val ConformLoadGroup: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def SeasonDayTypeSchedule: SeasonDayTypeSchedule = sup.asInstanceOf[SeasonDayTypeSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[ConformLoadSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConformLoadSchedule
extends
    Parseable[ConformLoadSchedule]
{
    val sup = SeasonDayTypeSchedule.parse _
    val ConformLoadGroup = parse_attribute (attribute ("""ConformLoadSchedule.ConformLoadGroup"""))_
    def parse (context: Context): ConformLoadSchedule =
    {
        ConformLoadSchedule(
            sup (context),
            ConformLoadGroup (context)
        )
    }
}

/**
 * Group of similar days.
 * For example it could be used to represent weekdays, weekend, or holidays.
 */
case class DayType
(

    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[DayType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DayType
extends
    Parseable[DayType]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): DayType =
    {
        DayType(
            sup (context)
        )
    }
}

/**
 * Describes an area having energy production or consumption.
 * Specializations are intended to support the load allocation function as typically required in energy management systems or planning studies to allocate hypothesized load levels to individual load points for power flow analysis.  Often the energy area can be linked to both measured and forecast load levels.
 */
case class EnergyArea
(

    override val sup: IdentifiedObject,

    /**
     * The control area specification that is used for the load forecast.
     */
    val ControlArea: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[EnergyArea]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnergyArea
extends
    Parseable[EnergyArea]
{
    val sup = IdentifiedObject.parse _
    val ControlArea = parse_attribute (attribute ("""EnergyArea.ControlArea"""))_
    def parse (context: Context): EnergyArea =
    {
        EnergyArea(
            sup (context),
            ControlArea (context)
        )
    }
}

/**
 * The class is the root or first level in a hierarchical structure for grouping of loads for the purpose of load flow load scaling.
 */
case class LoadArea
(

    override val sup: EnergyArea
)
extends
    Element
{
    def this () = { this (null) }
    def EnergyArea: EnergyArea = sup.asInstanceOf[EnergyArea]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadArea]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadArea
extends
    Parseable[LoadArea]
{
    val sup = EnergyArea.parse _
    def parse (context: Context): LoadArea =
    {
        LoadArea(
            sup (context)
        )
    }
}

/**
 * The class is the third level in a hierarchical structure for grouping of loads for the purpose of load flow load scaling.
 */
case class LoadGroup
(

    override val sup: IdentifiedObject,

    /**
     * The SubLoadArea where the Loadgroup belongs.
     */
    val SubLoadArea: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadGroup]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadGroup
extends
    Parseable[LoadGroup]
{
    val sup = IdentifiedObject.parse _
    val SubLoadArea = parse_attribute (attribute ("""LoadGroup.SubLoadArea"""))_
    def parse (context: Context): LoadGroup =
    {
        LoadGroup(
            sup (context),
            SubLoadArea (context)
        )
    }
}

/**
 * Models the characteristic response of the load demand due to changes in system conditions such as voltage and frequency.
 * This is not related to demand response.
 */
case class LoadResponseCharacteristic
(

    override val sup: IdentifiedObject,

    /**
     * Indicates the exponential voltage dependency model is to be used.
     * If false, the coefficient model is to be used.
     */
    val exponentModel: Boolean,

    /**
     * Portion of active power load modeled as constant current.
     */
    val pConstantCurrent: Double,

    /**
     * Portion of active power load modeled as constant impedance.
     */
    val pConstantImpedance: Double,

    /**
     * Portion of active power load modeled as constant power.
     */
    val pConstantPower: Double,

    /**
     * Exponent of per unit frequency effecting active power.
     */
    val pFrequencyExponent: Double,

    /**
     * Exponent of per unit voltage effecting real power.
     */
    val pVoltageExponent: Double,

    /**
     * Portion of reactive power load modeled as constant current.
     */
    val qConstantCurrent: Double,

    /**
     * Portion of reactive power load modeled as constant impedance.
     */
    val qConstantImpedance: Double,

    /**
     * Portion of reactive power load modeled as constant power.
     */
    val qConstantPower: Double,

    /**
     * Exponent of per unit frequency effecting reactive power.
     */
    val qFrequencyExponent: Double,

    /**
     * Exponent of per unit voltage effecting reactive power.
     */
    val qVoltageExponent: Double
)
extends
    Element
{
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadResponseCharacteristic]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadResponseCharacteristic
extends
    Parseable[LoadResponseCharacteristic]
{
    val sup = IdentifiedObject.parse _
    val exponentModel = parse_element (element ("""LoadResponseCharacteristic.exponentModel"""))_
    val pConstantCurrent = parse_element (element ("""LoadResponseCharacteristic.pConstantCurrent"""))_
    val pConstantImpedance = parse_element (element ("""LoadResponseCharacteristic.pConstantImpedance"""))_
    val pConstantPower = parse_element (element ("""LoadResponseCharacteristic.pConstantPower"""))_
    val pFrequencyExponent = parse_element (element ("""LoadResponseCharacteristic.pFrequencyExponent"""))_
    val pVoltageExponent = parse_element (element ("""LoadResponseCharacteristic.pVoltageExponent"""))_
    val qConstantCurrent = parse_element (element ("""LoadResponseCharacteristic.qConstantCurrent"""))_
    val qConstantImpedance = parse_element (element ("""LoadResponseCharacteristic.qConstantImpedance"""))_
    val qConstantPower = parse_element (element ("""LoadResponseCharacteristic.qConstantPower"""))_
    val qFrequencyExponent = parse_element (element ("""LoadResponseCharacteristic.qFrequencyExponent"""))_
    val qVoltageExponent = parse_element (element ("""LoadResponseCharacteristic.qVoltageExponent"""))_
    def parse (context: Context): LoadResponseCharacteristic =
    {
        LoadResponseCharacteristic(
            sup (context),
            toBoolean (exponentModel (context), context),
            toDouble (pConstantCurrent (context), context),
            toDouble (pConstantImpedance (context), context),
            toDouble (pConstantPower (context), context),
            toDouble (pFrequencyExponent (context), context),
            toDouble (pVoltageExponent (context), context),
            toDouble (qConstantCurrent (context), context),
            toDouble (qConstantImpedance (context), context),
            toDouble (qConstantPower (context), context),
            toDouble (qFrequencyExponent (context), context),
            toDouble (qVoltageExponent (context), context)
        )
    }
}

/**
 * NonConformLoad represent loads that do not follow a daily load change pattern and changes are not correlated with the daily load change pattern.
 */
case class NonConformLoad
(

    override val sup: EnergyConsumer,

    /**
     * Group of this ConformLoad.
     */
    val LoadGroup: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def EnergyConsumer: EnergyConsumer = sup.asInstanceOf[EnergyConsumer]
    override def copy (): Row = { return (clone ().asInstanceOf[NonConformLoad]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NonConformLoad
extends
    Parseable[NonConformLoad]
{
    val sup = EnergyConsumer.parse _
    val LoadGroup = parse_attribute (attribute ("""NonConformLoad.LoadGroup"""))_
    def parse (context: Context): NonConformLoad =
    {
        NonConformLoad(
            sup (context),
            LoadGroup (context)
        )
    }
}

/**
 * Loads that do not follow a daily and seasonal load variation pattern.
 */
case class NonConformLoadGroup
(

    override val sup: LoadGroup
)
extends
    Element
{
    def this () = { this (null) }
    def LoadGroup: LoadGroup = sup.asInstanceOf[LoadGroup]
    override def copy (): Row = { return (clone ().asInstanceOf[NonConformLoadGroup]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NonConformLoadGroup
extends
    Parseable[NonConformLoadGroup]
{
    val sup = LoadGroup.parse _
    def parse (context: Context): NonConformLoadGroup =
    {
        NonConformLoadGroup(
            sup (context)
        )
    }
}

/**
 * An active power (Y1-axis) and reactive power (Y2-axis) schedule (curves) versus time (X-axis) for non-conforming loads, e.g., large industrial load or power station service (where modeled).
 */
case class NonConformLoadSchedule
(

    override val sup: SeasonDayTypeSchedule,

    /**
     * The NonConformLoadGroup where the NonConformLoadSchedule belongs.
     */
    val NonConformLoadGroup: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def SeasonDayTypeSchedule: SeasonDayTypeSchedule = sup.asInstanceOf[SeasonDayTypeSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[NonConformLoadSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NonConformLoadSchedule
extends
    Parseable[NonConformLoadSchedule]
{
    val sup = SeasonDayTypeSchedule.parse _
    val NonConformLoadGroup = parse_attribute (attribute ("""NonConformLoadSchedule.NonConformLoadGroup"""))_
    def parse (context: Context): NonConformLoadSchedule =
    {
        NonConformLoadSchedule(
            sup (context),
            NonConformLoadGroup (context)
        )
    }
}

/**
 * An area or zone of the power system which is used for load shedding purposes.
 */
case class PowerCutZone
(

    override val sup: PowerSystemResource,

    /**
     * First level (amount) of load to cut as a percentage of total zone load.
     */
    val cutLevel1: Double,

    /**
     * Second level (amount) of load to cut as a percentage of total zone load.
     */
    val cutLevel2: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[PowerCutZone]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PowerCutZone
extends
    Parseable[PowerCutZone]
{
    val sup = PowerSystemResource.parse _
    val cutLevel1 = parse_element (element ("""PowerCutZone.cutLevel1"""))_
    val cutLevel2 = parse_element (element ("""PowerCutZone.cutLevel2"""))_
    def parse (context: Context): PowerCutZone =
    {
        PowerCutZone(
            sup (context),
            toDouble (cutLevel1 (context), context),
            toDouble (cutLevel2 (context), context)
        )
    }
}

/**
 * A specified time period of the year.
 */
case class Season
(

    override val sup: IdentifiedObject,

    /**
     * Date season ends.
     */
    val endDate: String,

    /**
     * Date season starts.
     */
    val startDate: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Season]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Season
extends
    Parseable[Season]
{
    val sup = IdentifiedObject.parse _
    val endDate = parse_element (element ("""Season.endDate"""))_
    val startDate = parse_element (element ("""Season.startDate"""))_
    def parse (context: Context): Season =
    {
        Season(
            sup (context),
            endDate (context),
            startDate (context)
        )
    }
}

/**
 * A time schedule covering a 24 hour period, with curve data for a specific type of season and day.
 */
case class SeasonDayTypeSchedule
(

    override val sup: RegularIntervalSchedule,

    /**
     * DayType for the Schedule.
     */
    val DayType: String,

    /**
     * Season for the Schedule.
     */
    val Season: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[SeasonDayTypeSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SeasonDayTypeSchedule
extends
    Parseable[SeasonDayTypeSchedule]
{
    val sup = RegularIntervalSchedule.parse _
    val DayType = parse_attribute (attribute ("""SeasonDayTypeSchedule.DayType"""))_
    val Season = parse_attribute (attribute ("""SeasonDayTypeSchedule.Season"""))_
    def parse (context: Context): SeasonDayTypeSchedule =
    {
        SeasonDayTypeSchedule(
            sup (context),
            DayType (context),
            Season (context)
        )
    }
}

/**
 * Station supply with load derived from the station output.
 */
case class StationSupply
(

    override val sup: EnergyConsumer
)
extends
    Element
{
    def this () = { this (null) }
    def EnergyConsumer: EnergyConsumer = sup.asInstanceOf[EnergyConsumer]
    override def copy (): Row = { return (clone ().asInstanceOf[StationSupply]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StationSupply
extends
    Parseable[StationSupply]
{
    val sup = EnergyConsumer.parse _
    def parse (context: Context): StationSupply =
    {
        StationSupply(
            sup (context)
        )
    }
}

/**
 * The class is the second level in a hierarchical structure for grouping of loads for the purpose of load flow load scaling.
 */
case class SubLoadArea
(

    override val sup: EnergyArea,

    /**
     * The LoadArea where the SubLoadArea belongs.
     */
    val LoadArea: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def EnergyArea: EnergyArea = sup.asInstanceOf[EnergyArea]
    override def copy (): Row = { return (clone ().asInstanceOf[SubLoadArea]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SubLoadArea
extends
    Parseable[SubLoadArea]
{
    val sup = EnergyArea.parse _
    val LoadArea = parse_attribute (attribute ("""SubLoadArea.LoadArea"""))_
    def parse (context: Context): SubLoadArea =
    {
        SubLoadArea(
            sup (context),
            LoadArea (context)
        )
    }
}

object _LoadModel
{
    def register: Unit =
    {
        ConformLoad.register
        ConformLoadGroup.register
        ConformLoadSchedule.register
        DayType.register
        EnergyArea.register
        LoadArea.register
        LoadGroup.register
        LoadResponseCharacteristic.register
        NonConformLoad.register
        NonConformLoadGroup.register
        NonConformLoadSchedule.register
        PowerCutZone.register
        Season.register
        SeasonDayTypeSchedule.register
        StationSupply.register
        SubLoadArea.register
    }
}