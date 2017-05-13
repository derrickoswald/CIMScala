package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Contains entities that describe dynamic measurement data exchanged between applications.
 */

/**
 * Accumulator represents an accumulated (counted) Measurement, e.g. an energy value.
 */
case class Accumulator
(

    override val sup: Measurement,

    /**
     * Normal value range maximum for any of the MeasurementValue.values.
     * Used for scaling, e.g. in bar graphs or of telemetered raw values.
     */
    val maxValue: Int,

    /**
     * A measurement may have zero or more limit ranges defined for it.
     */
    val LimitSets: List[String]
)
extends
    Element
{
    def this () = { this (null, 0, List()) }
    def Measurement: Measurement = sup.asInstanceOf[Measurement]
    override def copy (): Row = { return (clone ().asInstanceOf[Accumulator]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Accumulator
extends
    Parseable[Accumulator]
{
    val sup = Measurement.parse _
    val maxValue = parse_element (element ("""Accumulator.maxValue"""))_
    val LimitSets = parse_attributes (attribute ("""Accumulator.LimitSets"""))_
    def parse (context: Context): Accumulator =
    {
        Accumulator(
            sup (context),
            toInteger (maxValue (context), context),
            LimitSets (context)
        )
    }
}

/**
 * Limit values for Accumulator measurements.
 */
case class AccumulatorLimit
(

    override val sup: Limit,

    /**
     * The value to supervise against.
     * The value is positive.
     */
    val value: Int,

    /**
     * The set of limits.
     */
    val LimitSet: String
)
extends
    Element
{
    def this () = { this (null, 0, null) }
    def Limit: Limit = sup.asInstanceOf[Limit]
    override def copy (): Row = { return (clone ().asInstanceOf[AccumulatorLimit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AccumulatorLimit
extends
    Parseable[AccumulatorLimit]
{
    val sup = Limit.parse _
    val value = parse_element (element ("""AccumulatorLimit.value"""))_
    val LimitSet = parse_attribute (attribute ("""AccumulatorLimit.LimitSet"""))_
    def parse (context: Context): AccumulatorLimit =
    {
        AccumulatorLimit(
            sup (context),
            toInteger (value (context), context),
            LimitSet (context)
        )
    }
}

/**
 * An AccumulatorLimitSet specifies a set of Limits that are associated with an Accumulator measurement.
 */
case class AccumulatorLimitSet
(

    override val sup: LimitSet
)
extends
    Element
{
    def this () = { this (null) }
    def LimitSet: LimitSet = sup.asInstanceOf[LimitSet]
    override def copy (): Row = { return (clone ().asInstanceOf[AccumulatorLimitSet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AccumulatorLimitSet
extends
    Parseable[AccumulatorLimitSet]
{
    val sup = LimitSet.parse _
    def parse (context: Context): AccumulatorLimitSet =
    {
        AccumulatorLimitSet(
            sup (context)
        )
    }
}

/**
 * This command reset the counter value to zero.
 */
case class AccumulatorReset
(

    override val sup: Control,

    /**
     * The accumulator value that is reset by the command.
     */
    val AccumulatorValue: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Control: Control = sup.asInstanceOf[Control]
    override def copy (): Row = { return (clone ().asInstanceOf[AccumulatorReset]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AccumulatorReset
extends
    Parseable[AccumulatorReset]
{
    val sup = Control.parse _
    val AccumulatorValue = parse_attribute (attribute ("""AccumulatorReset.AccumulatorValue"""))_
    def parse (context: Context): AccumulatorReset =
    {
        AccumulatorReset(
            sup (context),
            AccumulatorValue (context)
        )
    }
}

/**
 * AccumulatorValue represents an accumulated (counted) MeasurementValue.
 */
case class AccumulatorValue
(

    override val sup: MeasurementValue,

    /**
     * The value to supervise.
     * The value is positive.
     */
    val value: Int,

    /**
     * Measurement to which this value is connected.
     */
    val Accumulator: String,

    /**
     * The command that reset the accumulator value.
     */
    val AccumulatorReset: String
)
extends
    Element
{
    def this () = { this (null, 0, null, null) }
    def MeasurementValue: MeasurementValue = sup.asInstanceOf[MeasurementValue]
    override def copy (): Row = { return (clone ().asInstanceOf[AccumulatorValue]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AccumulatorValue
extends
    Parseable[AccumulatorValue]
{
    val sup = MeasurementValue.parse _
    val value = parse_element (element ("""AccumulatorValue.value"""))_
    val Accumulator = parse_attribute (attribute ("""AccumulatorValue.Accumulator"""))_
    val AccumulatorReset = parse_attribute (attribute ("""AccumulatorValue.AccumulatorReset"""))_
    def parse (context: Context): AccumulatorValue =
    {
        AccumulatorValue(
            sup (context),
            toInteger (value (context), context),
            Accumulator (context),
            AccumulatorReset (context)
        )
    }
}

/**
 * Analog represents an analog Measurement.
 */
case class Analog
(

    override val sup: Measurement,

    /**
     * Normal value range maximum for any of the MeasurementValue.values.
     * Used for scaling, e.g. in bar graphs or of telemetered raw values.
     */
    val maxValue: Double,

    /**
     * Normal value range minimum for any of the MeasurementValue.values.
     * Used for scaling, e.g. in bar graphs or of telemetered raw values.
     */
    val minValue: Double,

    /**
     * Normal measurement value, e.g., used for percentage calculations.
     */
    val normalValue: Double,

    /**
     * If true then this measurement is an active power, reactive power or current with the convention that a positive value measured at the Terminal means power is flowing into the related PowerSystemResource.
     */
    val positiveFlowIn: Boolean,

    /**
     * A measurement may have zero or more limit ranges defined for it.
     */
    val LimitSets: List[String]
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, false, List()) }
    def Measurement: Measurement = sup.asInstanceOf[Measurement]
    override def copy (): Row = { return (clone ().asInstanceOf[Analog]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Analog
extends
    Parseable[Analog]
{
    val sup = Measurement.parse _
    val maxValue = parse_element (element ("""Analog.maxValue"""))_
    val minValue = parse_element (element ("""Analog.minValue"""))_
    val normalValue = parse_element (element ("""Analog.normalValue"""))_
    val positiveFlowIn = parse_element (element ("""Analog.positiveFlowIn"""))_
    val LimitSets = parse_attributes (attribute ("""Analog.LimitSets"""))_
    def parse (context: Context): Analog =
    {
        Analog(
            sup (context),
            toDouble (maxValue (context), context),
            toDouble (minValue (context), context),
            toDouble (normalValue (context), context),
            toBoolean (positiveFlowIn (context), context),
            LimitSets (context)
        )
    }
}

/**
 * An analog control used for supervisory control.
 */
case class AnalogControl
(

    override val sup: Control,

    /**
     * Normal value range maximum for any of the Control.value.
     * Used for scaling, e.g. in bar graphs.
     */
    val maxValue: Double,

    /**
     * Normal value range minimum for any of the Control.value.
     * Used for scaling, e.g. in bar graphs.
     */
    val minValue: Double,

    /**
     * The MeasurementValue that is controlled.
     */
    val AnalogValue: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null) }
    def Control: Control = sup.asInstanceOf[Control]
    override def copy (): Row = { return (clone ().asInstanceOf[AnalogControl]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AnalogControl
extends
    Parseable[AnalogControl]
{
    val sup = Control.parse _
    val maxValue = parse_element (element ("""AnalogControl.maxValue"""))_
    val minValue = parse_element (element ("""AnalogControl.minValue"""))_
    val AnalogValue = parse_attribute (attribute ("""AnalogControl.AnalogValue"""))_
    def parse (context: Context): AnalogControl =
    {
        AnalogControl(
            sup (context),
            toDouble (maxValue (context), context),
            toDouble (minValue (context), context),
            AnalogValue (context)
        )
    }
}

/**
 * Limit values for Analog measurements.
 */
case class AnalogLimit
(

    override val sup: Limit,

    /**
     * The value to supervise against.
     */
    val value: Double,

    /**
     * The set of limits.
     */
    val LimitSet: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null) }
    def Limit: Limit = sup.asInstanceOf[Limit]
    override def copy (): Row = { return (clone ().asInstanceOf[AnalogLimit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AnalogLimit
extends
    Parseable[AnalogLimit]
{
    val sup = Limit.parse _
    val value = parse_element (element ("""AnalogLimit.value"""))_
    val LimitSet = parse_attribute (attribute ("""AnalogLimit.LimitSet"""))_
    def parse (context: Context): AnalogLimit =
    {
        AnalogLimit(
            sup (context),
            toDouble (value (context), context),
            LimitSet (context)
        )
    }
}

/**
 * An AnalogLimitSet specifies a set of Limits that are associated with an Analog measurement.
 */
case class AnalogLimitSet
(

    override val sup: LimitSet
)
extends
    Element
{
    def this () = { this (null) }
    def LimitSet: LimitSet = sup.asInstanceOf[LimitSet]
    override def copy (): Row = { return (clone ().asInstanceOf[AnalogLimitSet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AnalogLimitSet
extends
    Parseable[AnalogLimitSet]
{
    val sup = LimitSet.parse _
    def parse (context: Context): AnalogLimitSet =
    {
        AnalogLimitSet(
            sup (context)
        )
    }
}

/**
 * AnalogValue represents an analog MeasurementValue.
 */
case class AnalogValue
(

    override val sup: MeasurementValue,

    /**
     * The value to supervise.
     */
    val value: Double,

    /**
     * Measurement to which this value is connected.
     */
    val Analog: String,

    /**
     * The Control variable associated with the MeasurementValue.
     */
    val AnalogControl: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def MeasurementValue: MeasurementValue = sup.asInstanceOf[MeasurementValue]
    override def copy (): Row = { return (clone ().asInstanceOf[AnalogValue]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AnalogValue
extends
    Parseable[AnalogValue]
{
    val sup = MeasurementValue.parse _
    val value = parse_element (element ("""AnalogValue.value"""))_
    val Analog = parse_attribute (attribute ("""AnalogValue.Analog"""))_
    val AnalogControl = parse_attribute (attribute ("""AnalogValue.AnalogControl"""))_
    def parse (context: Context): AnalogValue =
    {
        AnalogValue(
            sup (context),
            toDouble (value (context), context),
            Analog (context),
            AnalogControl (context)
        )
    }
}

/**
 * A Command is a discrete control used for supervisory control.
 */
case class Command
(

    override val sup: Control,

    /**
     * Normal value for Control.value e.g. used for percentage scaling.
     */
    val normalValue: Int,

    /**
     * The value representing the actuator output.
     */
    val value: Int,

    /**
     * The MeasurementValue that is controlled.
     */
    val DiscreteValue: String,

    /**
     * The ValueAliasSet used for translation of a Control value to a name.
     */
    val ValueAliasSet: String
)
extends
    Element
{
    def this () = { this (null, 0, 0, null, null) }
    def Control: Control = sup.asInstanceOf[Control]
    override def copy (): Row = { return (clone ().asInstanceOf[Command]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Command
extends
    Parseable[Command]
{
    val sup = Control.parse _
    val normalValue = parse_element (element ("""Command.normalValue"""))_
    val value = parse_element (element ("""Command.value"""))_
    val DiscreteValue = parse_attribute (attribute ("""Command.DiscreteValue"""))_
    val ValueAliasSet = parse_attribute (attribute ("""Command.ValueAliasSet"""))_
    def parse (context: Context): Command =
    {
        Command(
            sup (context),
            toInteger (normalValue (context), context),
            toInteger (value (context), context),
            DiscreteValue (context),
            ValueAliasSet (context)
        )
    }
}

/**
 * Control is used for supervisory/device control.
 * It represents control outputs that are used to change the state in a process, e.g. close or open breaker, a set point value or a raise lower command.
 */
case class Control
(

    override val sup: IdentifiedObject,

    /**
     * Specifies the type of Control, e.g.
     * BreakerOn/Off, GeneratorVoltageSetPoint, TieLineFlow etc. The ControlType.name shall be unique among all specified types and describe the type.
     */
    val controlType: String,

    /**
     * Indicates that a client is currently sending control commands that has not completed.
     */
    val operationInProgress: Boolean,

    /**
     * The last time a control output was sent.
     */
    val timeStamp: String,

    /**
     * The unit multiplier of the controlled quantity.
     */
    val unitMultiplier: String,

    /**
     * The unit of measure of the controlled quantity.
     */
    val unitSymbol: String,

    /**
     * Regulating device governed by this control output.
     */
    val PowerSystemResource: String,

    /**
     * The remote point controlling the physical actuator.
     */
    val RemoteControl: String
)
extends
    Element
{
    def this () = { this (null, null, false, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Control]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Control
extends
    Parseable[Control]
{
    val sup = IdentifiedObject.parse _
    val controlType = parse_element (element ("""Control.controlType"""))_
    val operationInProgress = parse_element (element ("""Control.operationInProgress"""))_
    val timeStamp = parse_element (element ("""Control.timeStamp"""))_
    val unitMultiplier = parse_attribute (attribute ("""Control.unitMultiplier"""))_
    val unitSymbol = parse_attribute (attribute ("""Control.unitSymbol"""))_
    val PowerSystemResource = parse_attribute (attribute ("""Control.PowerSystemResource"""))_
    val RemoteControl = parse_attribute (attribute ("""Control.RemoteControl"""))_
    def parse (context: Context): Control =
    {
        Control(
            sup (context),
            controlType (context),
            toBoolean (operationInProgress (context), context),
            timeStamp (context),
            unitMultiplier (context),
            unitSymbol (context),
            PowerSystemResource (context),
            RemoteControl (context)
        )
    }
}

/**
 * Discrete represents a discrete Measurement, i.e. a Measurement representing discrete values, e.g. a Breaker position.
 */
case class Discrete
(

    override val sup: Measurement,

    /**
     * Normal value range maximum for any of the MeasurementValue.values.
     * Used for scaling, e.g. in bar graphs or of telemetered raw values.
     */
    val maxValue: Int,

    /**
     * Normal value range minimum for any of the MeasurementValue.values.
     * Used for scaling, e.g. in bar graphs or of telemetered raw values.
     */
    val minValue: Int,

    /**
     * Normal measurement value, e.g., used for percentage calculations.
     */
    val normalValue: Int,

    /**
     * The ValueAliasSet used for translation of a MeasurementValue.value to a name.
     */
    val ValueAliasSet: String
)
extends
    Element
{
    def this () = { this (null, 0, 0, 0, null) }
    def Measurement: Measurement = sup.asInstanceOf[Measurement]
    override def copy (): Row = { return (clone ().asInstanceOf[Discrete]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Discrete
extends
    Parseable[Discrete]
{
    val sup = Measurement.parse _
    val maxValue = parse_element (element ("""Discrete.maxValue"""))_
    val minValue = parse_element (element ("""Discrete.minValue"""))_
    val normalValue = parse_element (element ("""Discrete.normalValue"""))_
    val ValueAliasSet = parse_attribute (attribute ("""Discrete.ValueAliasSet"""))_
    def parse (context: Context): Discrete =
    {
        Discrete(
            sup (context),
            toInteger (maxValue (context), context),
            toInteger (minValue (context), context),
            toInteger (normalValue (context), context),
            ValueAliasSet (context)
        )
    }
}

case class DiscreteCommand
(

    override val sup: Command
)
extends
    Element
{
    def this () = { this (null) }
    def Command: Command = sup.asInstanceOf[Command]
    override def copy (): Row = { return (clone ().asInstanceOf[DiscreteCommand]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiscreteCommand
extends
    Parseable[DiscreteCommand]
{
    val sup = Command.parse _
    def parse (context: Context): DiscreteCommand =
    {
        DiscreteCommand(
            sup (context)
        )
    }
}

/**
 * DiscreteValue represents a discrete MeasurementValue.
 */
case class DiscreteValue
(

    override val sup: MeasurementValue,

    /**
     * The value to supervise.
     */
    val value: Int,

    /**
     * The Control variable associated with the MeasurementValue.
     */
    val Command: String,

    /**
     * Measurement to which this value is connected.
     */
    val Discrete: String
)
extends
    Element
{
    def this () = { this (null, 0, null, null) }
    def MeasurementValue: MeasurementValue = sup.asInstanceOf[MeasurementValue]
    override def copy (): Row = { return (clone ().asInstanceOf[DiscreteValue]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiscreteValue
extends
    Parseable[DiscreteValue]
{
    val sup = MeasurementValue.parse _
    val value = parse_element (element ("""DiscreteValue.value"""))_
    val Command = parse_attribute (attribute ("""DiscreteValue.Command"""))_
    val Discrete = parse_attribute (attribute ("""DiscreteValue.Discrete"""))_
    def parse (context: Context): DiscreteValue =
    {
        DiscreteValue(
            sup (context),
            toInteger (value (context), context),
            Command (context),
            Discrete (context)
        )
    }
}

/**
 * Specifies one limit value for a Measurement.
 * A Measurement typically has several limits that are kept together by the LimitSet class. The actual meaning and use of a Limit instance (i.e., if it is an alarm or warning limit or if it is a high or low limit) is not captured in the Limit class. However the name of a Limit instance may indicate both meaning and use.
 */
case class Limit
(

    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Limit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Limit
extends
    Parseable[Limit]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): Limit =
    {
        Limit(
            sup (context)
        )
    }
}

/**
 * Specifies a set of Limits that are associated with a Measurement.
 * A Measurement may have several LimitSets corresponding to seasonal or other changing conditions. The condition is captured in the name and description attributes. The same LimitSet may be used for several Measurements. In particular percentage limits are used this way.
 */
case class LimitSet
(

    override val sup: IdentifiedObject,

    /**
     * Tells if the limit values are in percentage of normalValue or the specified Unit for Measurements and Controls.
     */
    val isPercentageLimits: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[LimitSet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LimitSet
extends
    Parseable[LimitSet]
{
    val sup = IdentifiedObject.parse _
    val isPercentageLimits = parse_element (element ("""LimitSet.isPercentageLimits"""))_
    def parse (context: Context): LimitSet =
    {
        LimitSet(
            sup (context),
            toBoolean (isPercentageLimits (context), context)
        )
    }
}

/**
 * A Measurement represents any measured, calculated or non-measured non-calculated quantity.
 * Any piece of equipment may contain Measurements, e.g. a substation may have temperature measurements and door open indications, a transformer may have oil temperature and tank pressure measurements, a bay may contain a number of power flow measurements and a Breaker may contain a switch status measurement.
 */
case class Measurement
(

    override val sup: IdentifiedObject,

    /**
     * Specifies the type of measurement.
     * For example, this specifies if the measurement represents an indoor temperature, outdoor temperature, bus voltage, line flow, etc.
     */
    val measurementType: String,

    /**
     * Indicates to which phases the measurement applies and avoids the need to use 'measurementType' to also encode phase information (which would explode the types).
     * The phase information in Measurement, along with 'measurementType' and 'phases' uniquely defines a Measurement for a device, based on normal network phase. Their meaning will not change when the computed energizing phasing is changed due to jumpers or other reasons.
     */
    val phases: String,

    /**
     * The unit multiplier of the measured quantity.
     */
    val unitMultiplier: String,

    /**
     * The unit of measure of the measured quantity.
     */
    val unitSymbol: String,

    val Asset: String,

    /**
     * The power system resource that contains the measurement.
     */
    val PowerSystemResource: String,

    /**
     * One or more measurements may be associated with a terminal in the network.
     */
    val Terminal: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Measurement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Measurement
extends
    Parseable[Measurement]
{
    val sup = IdentifiedObject.parse _
    val measurementType = parse_element (element ("""Measurement.measurementType"""))_
    val phases = parse_attribute (attribute ("""Measurement.phases"""))_
    val unitMultiplier = parse_attribute (attribute ("""Measurement.unitMultiplier"""))_
    val unitSymbol = parse_attribute (attribute ("""Measurement.unitSymbol"""))_
    val Asset = parse_attribute (attribute ("""Measurement.Asset"""))_
    val PowerSystemResource = parse_attribute (attribute ("""Measurement.PowerSystemResource"""))_
    val Terminal = parse_attribute (attribute ("""Measurement.Terminal"""))_
    def parse (context: Context): Measurement =
    {
        Measurement(
            sup (context),
            measurementType (context),
            phases (context),
            unitMultiplier (context),
            unitSymbol (context),
            Asset (context),
            PowerSystemResource (context),
            Terminal (context)
        )
    }
}

/**
 * The current state for a measurement.
 * A state value is an instance of a measurement from a specific source. Measurements can be associated with many state values, each representing a different source for the measurement.
 */
case class MeasurementValue
(

    override val sup: IdentifiedObject,

    val attr: String,

    /**
     * The limit, expressed as a percentage of the sensor maximum, that errors will not exceed when the sensor is used under  reference conditions.
     */
    val sensorAccuracy: Double,

    /**
     * The time when the value was last updated
     */
    val timeStamp: String,

    val ErpPerson: String,

    /**
     * A MeasurementValue has a MeasurementValueQuality associated with it.
     */
    val MeasurementValueQuality: String,

    /**
     * A reference to the type of source that updates the MeasurementValue, e.g.
     * SCADA, CCLink, manual, etc. User conventions for the names of sources are contained in the introduction to IEC 61970-301.
     */
    val MeasurementValueSource: String,

    /**
     * Link to the physical telemetered point associated with this measurement.
     */
    val RemoteSource: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MeasurementValue]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MeasurementValue
extends
    Parseable[MeasurementValue]
{
    val sup = IdentifiedObject.parse _
    val attr = parse_attribute (attribute ("""MeasurementValue."""))_
    val sensorAccuracy = parse_element (element ("""MeasurementValue.sensorAccuracy"""))_
    val timeStamp = parse_element (element ("""MeasurementValue.timeStamp"""))_
    val ErpPerson = parse_attribute (attribute ("""MeasurementValue.ErpPerson"""))_
    val MeasurementValueQuality = parse_attribute (attribute ("""MeasurementValue.MeasurementValueQuality"""))_
    val MeasurementValueSource = parse_attribute (attribute ("""MeasurementValue.MeasurementValueSource"""))_
    val RemoteSource = parse_attribute (attribute ("""MeasurementValue.RemoteSource"""))_
    def parse (context: Context): MeasurementValue =
    {
        MeasurementValue(
            sup (context),
            attr (context),
            toDouble (sensorAccuracy (context), context),
            timeStamp (context),
            ErpPerson (context),
            MeasurementValueQuality (context),
            MeasurementValueSource (context),
            RemoteSource (context)
        )
    }
}

/**
 * Measurement quality flags.
 * Bits 0-10 are defined for substation automation in draft IEC 61850 part 7-3. Bits 11-15 are reserved for future expansion by that document. Bits 16-31 are reserved for EMS applications.
 */
case class MeasurementValueQuality
(

    override val sup: Quality61850,

    /**
     * A MeasurementValue has a MeasurementValueQuality associated with it.
     */
    val MeasurementValue: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Quality61850: Quality61850 = sup.asInstanceOf[Quality61850]
    override def copy (): Row = { return (clone ().asInstanceOf[MeasurementValueQuality]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MeasurementValueQuality
extends
    Parseable[MeasurementValueQuality]
{
    val sup = Quality61850.parse _
    val MeasurementValue = parse_attribute (attribute ("""MeasurementValueQuality.MeasurementValue"""))_
    def parse (context: Context): MeasurementValueQuality =
    {
        MeasurementValueQuality(
            sup (context),
            MeasurementValue (context)
        )
    }
}

/**
 * MeasurementValueSource describes the alternative sources updating a MeasurementValue.
 * User conventions for how to use the MeasurementValueSource attributes are described in the introduction to IEC 61970-301.
 */
case class MeasurementValueSource
(

    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MeasurementValueSource]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MeasurementValueSource
extends
    Parseable[MeasurementValueSource]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): MeasurementValueSource =
    {
        MeasurementValueSource(
            sup (context)
        )
    }
}

/**
 * Quality flags in this class are as defined in IEC 61850, except for estimatorReplaced, which has been included in this class for convenience.
 */
case class Quality61850
(

    override val sup: BasicElement,

    /**
     * Measurement value may be incorrect due to a reference being out of calibration.
     */
    val badReference: Boolean,

    /**
     * Value has been replaced by State Estimator. estimatorReplaced is not an IEC61850 quality bit but has been put in this class for convenience.
     */
    val estimatorReplaced: Boolean,

    /**
     * This identifier indicates that a supervision function has detected an internal or external failure, e.g. communication failure.
     */
    val failure: Boolean,

    /**
     * Measurement value is old and possibly invalid, as it has not been successfully updated during a specified time interval.
     */
    val oldData: Boolean,

    /**
     * Measurement value is blocked and hence unavailable for transmission.
     */
    val operatorBlocked: Boolean,

    /**
     * To prevent some overload of the communication it is sensible to detect and suppress oscillating (fast changing) binary inputs.
     * If a signal changes in a defined time (tosc) twice in the same direction (from 0 to 1 or from 1 to 0) then oscillation is detected and the detail quality identifier "oscillatory" is set. If it is detected a configured numbers of transient changes could be passed by. In this time the validity status "questionable" is set. If after this defined numbers of changes the signal is still in the oscillating state the value shall be set either to the opposite state of the previous stable value or to a defined default value. In this case the validity status "questionable" is reset and "invalid" is set as long as the signal is oscillating. If it is configured such that no transient changes should be passed by then the validity status "invalid" is set immediately in addition to the detail quality identifier "oscillatory" (used for status information only).
     */
    val oscillatory: Boolean,

    /**
     * Measurement value is beyond a predefined range of value.
     */
    val outOfRange: Boolean,

    /**
     * Measurement value is beyond the capability of being  represented properly.
     * For example, a counter value overflows from maximum count back to a value of zero.
     */
    val overFlow: Boolean,

    /**
     * Source gives information related to the origin of a value.
     * The value may be acquired from the process, defaulted or substituted.
     */
    val source: String,

    /**
     * A correlation function has detected that the value is not consitent with other values.
     * Typically set by a network State Estimator.
     */
    val suspect: Boolean,

    /**
     * Measurement value is transmitted for test purposes.
     */
    val test: Boolean,

    /**
     * Validity of the measurement value.
     */
    val validity: String
)
extends
    Element
{
    def this () = { this (null, false, false, false, false, false, false, false, false, null, false, false, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Quality61850]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Quality61850
extends
    Parseable[Quality61850]
{
    val sup = BasicElement.parse _
    val badReference = parse_element (element ("""Quality61850.badReference"""))_
    val estimatorReplaced = parse_element (element ("""Quality61850.estimatorReplaced"""))_
    val failure = parse_element (element ("""Quality61850.failure"""))_
    val oldData = parse_element (element ("""Quality61850.oldData"""))_
    val operatorBlocked = parse_element (element ("""Quality61850.operatorBlocked"""))_
    val oscillatory = parse_element (element ("""Quality61850.oscillatory"""))_
    val outOfRange = parse_element (element ("""Quality61850.outOfRange"""))_
    val overFlow = parse_element (element ("""Quality61850.overFlow"""))_
    val source = parse_attribute (attribute ("""Quality61850.source"""))_
    val suspect = parse_element (element ("""Quality61850.suspect"""))_
    val test = parse_element (element ("""Quality61850.test"""))_
    val validity = parse_attribute (attribute ("""Quality61850.validity"""))_
    def parse (context: Context): Quality61850 =
    {
        Quality61850(
            sup (context),
            toBoolean (badReference (context), context),
            toBoolean (estimatorReplaced (context), context),
            toBoolean (failure (context), context),
            toBoolean (oldData (context), context),
            toBoolean (operatorBlocked (context), context),
            toBoolean (oscillatory (context), context),
            toBoolean (outOfRange (context), context),
            toBoolean (overFlow (context), context),
            source (context),
            toBoolean (suspect (context), context),
            toBoolean (test (context), context),
            validity (context)
        )
    }
}

/**
 * An analog control that increase or decrease a set point value with pulses.
 */
case class RaiseLowerCommand
(

    override val sup: AnalogControl,

    /**
     * The ValueAliasSet used for translation of a Control value to a name.
     */
    val ValueAliasSet: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def AnalogControl: AnalogControl = sup.asInstanceOf[AnalogControl]
    override def copy (): Row = { return (clone ().asInstanceOf[RaiseLowerCommand]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RaiseLowerCommand
extends
    Parseable[RaiseLowerCommand]
{
    val sup = AnalogControl.parse _
    val ValueAliasSet = parse_attribute (attribute ("""RaiseLowerCommand.ValueAliasSet"""))_
    def parse (context: Context): RaiseLowerCommand =
    {
        RaiseLowerCommand(
            sup (context),
            ValueAliasSet (context)
        )
    }
}

/**
 * An analog control that issue a set point value.
 */
case class SetPoint
(

    override val sup: AnalogControl,

    /**
     * Normal value for Control.value e.g. used for percentage scaling.
     */
    val normalValue: Double,

    /**
     * The value representing the actuator output.
     */
    val value: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
    def AnalogControl: AnalogControl = sup.asInstanceOf[AnalogControl]
    override def copy (): Row = { return (clone ().asInstanceOf[SetPoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SetPoint
extends
    Parseable[SetPoint]
{
    val sup = AnalogControl.parse _
    val normalValue = parse_element (element ("""SetPoint.normalValue"""))_
    val value = parse_element (element ("""SetPoint.value"""))_
    def parse (context: Context): SetPoint =
    {
        SetPoint(
            sup (context),
            toDouble (normalValue (context), context),
            toDouble (value (context), context)
        )
    }
}

/**
 * StringMeasurement represents a measurement with values of type string.
 */
case class StringMeasurement
(

    override val sup: Measurement
)
extends
    Element
{
    def this () = { this (null) }
    def Measurement: Measurement = sup.asInstanceOf[Measurement]
    override def copy (): Row = { return (clone ().asInstanceOf[StringMeasurement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StringMeasurement
extends
    Parseable[StringMeasurement]
{
    val sup = Measurement.parse _
    def parse (context: Context): StringMeasurement =
    {
        StringMeasurement(
            sup (context)
        )
    }
}

/**
 * StringMeasurementValue represents a measurement value of type string.
 */
case class StringMeasurementValue
(

    override val sup: MeasurementValue,

    /**
     * The value to supervise.
     */
    val value: String,

    /**
     * Measurement to which this value is connected.
     */
    val StringMeasurement: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def MeasurementValue: MeasurementValue = sup.asInstanceOf[MeasurementValue]
    override def copy (): Row = { return (clone ().asInstanceOf[StringMeasurementValue]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StringMeasurementValue
extends
    Parseable[StringMeasurementValue]
{
    val sup = MeasurementValue.parse _
    val value = parse_element (element ("""StringMeasurementValue.value"""))_
    val StringMeasurement = parse_attribute (attribute ("""StringMeasurementValue.StringMeasurement"""))_
    def parse (context: Context): StringMeasurementValue =
    {
        StringMeasurementValue(
            sup (context),
            value (context),
            StringMeasurement (context)
        )
    }
}

/**
 * Validity for MeasurementValue.
 */
case class Validity
(

    override val sup: BasicElement,

    /**
     * The value is marked good if no abnormal condition of the acquisition function or the information source is detected.
     */
    val GOOD: String,

    /**
     * The value is marked invalid when a supervision function recognises abnormal conditions of the acquisition function or the information source (missing or non-operating updating devices).
     * The value is not defined under this condition. The mark invalid is used to indicate to the client that the value may be incorrect and shall not be used.
     */
    val INVALID: String,

    /**
     * The value is marked questionable if a supervision function detects an abnormal behaviour, however the value could still be valid.
     * The client is responsible for determining whether or not values marked "questionable" should be used.
     */
    val QUESTIONABLE: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Validity]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Validity
extends
    Parseable[Validity]
{
    val sup = BasicElement.parse _
    val GOOD = parse_attribute (attribute ("""Validity.GOOD"""))_
    val INVALID = parse_attribute (attribute ("""Validity.INVALID"""))_
    val QUESTIONABLE = parse_attribute (attribute ("""Validity.QUESTIONABLE"""))_
    def parse (context: Context): Validity =
    {
        Validity(
            sup (context),
            GOOD (context),
            INVALID (context),
            QUESTIONABLE (context)
        )
    }
}

/**
 * Describes the translation of a set of values into a name and is intendend to facilitate cusom translations.
 * Each ValueAliasSet has a name, description etc. A specific Measurement may represent a discrete state like Open, Closed, Intermediate etc. This requires a translation from the MeasurementValue.value number to a string, e.g. 0-&gt;"Invalid", 1-&gt;"Open", 2-&gt;"Closed", 3-&gt;"Intermediate". Each ValueToAlias member in ValueAliasSet.Value describe a mapping for one particular value to a name.
 */
case class ValueAliasSet
(

    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ValueAliasSet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ValueAliasSet
extends
    Parseable[ValueAliasSet]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): ValueAliasSet =
    {
        ValueAliasSet(
            sup (context)
        )
    }
}

/**
 * Describes the translation of one particular value into a name, e.g. 1 as "Open".
 */
case class ValueToAlias
(

    override val sup: IdentifiedObject,

    /**
     * The value that is mapped.
     */
    val value: Int,

    /**
     * The ValueAliasSet having the ValueToAlias mappings.
     */
    val ValueAliasSet: String
)
extends
    Element
{
    def this () = { this (null, 0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ValueToAlias]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ValueToAlias
extends
    Parseable[ValueToAlias]
{
    val sup = IdentifiedObject.parse _
    val value = parse_element (element ("""ValueToAlias.value"""))_
    val ValueAliasSet = parse_attribute (attribute ("""ValueToAlias.ValueAliasSet"""))_
    def parse (context: Context): ValueToAlias =
    {
        ValueToAlias(
            sup (context),
            toInteger (value (context), context),
            ValueAliasSet (context)
        )
    }
}

object _Meas
{
    def register: Unit =
    {
        Accumulator.register
        AccumulatorLimit.register
        AccumulatorLimitSet.register
        AccumulatorReset.register
        AccumulatorValue.register
        Analog.register
        AnalogControl.register
        AnalogLimit.register
        AnalogLimitSet.register
        AnalogValue.register
        Command.register
        Control.register
        Discrete.register
        DiscreteCommand.register
        DiscreteValue.register
        Limit.register
        LimitSet.register
        Measurement.register
        MeasurementValue.register
        MeasurementValueQuality.register
        MeasurementValueSource.register
        Quality61850.register
        RaiseLowerCommand.register
        SetPoint.register
        StringMeasurement.register
        StringMeasurementValue.register
        Validity.register
        ValueAliasSet.register
        ValueToAlias.register
    }
}