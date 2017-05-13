package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes.
 * Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 */

/**
 * Models Market clearing results.
 * Indicates market horizon, interval based. Used by a market quality system for billing and settlement purposes
 */
case class AllocationResult
(

    override val sup: BasicElement,

    val intervalStartTime: String,

    val updateTimeStamp: String,

    val updateUser: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AllocationResult]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AllocationResult
extends
    Parseable[AllocationResult]
{
    val sup = BasicElement.parse _
    val intervalStartTime = parse_element (element ("""AllocationResult.intervalStartTime"""))_
    val updateTimeStamp = parse_element (element ("""AllocationResult.updateTimeStamp"""))_
    val updateUser = parse_element (element ("""AllocationResult.updateUser"""))_
    def parse (context: Context): AllocationResult =
    {
        AllocationResult(
            sup (context),
            intervalStartTime (context),
            updateTimeStamp (context),
            updateUser (context)
        )
    }
}

/**
 * Models Market clearing results in terms of price and MW values
 */
case class AllocationResultValues
(

    override val sup: BasicElement,

    /**
     * "1" --  "Detail",
    "2" --  "Aggregate by Market service type", in which case, the "AllocationEnergyType" field will not be filled;
     * "3" --  "Aggregate by "AllocationEnergyType", in which case "MarketServiceType" will not be filled.
     */
    val aggregateType: String,

    val allocationMwHour: Double,

    val allocationPrice: Double,

    val energyTypeCode: String,

    /**
     * Choices are: 
    ME - Market Energy Capacity; 
    SR - Spinning Reserve Capacity; 
    NR - Non-Spinning Reserve Capacity; 
    DAC - Day Ahead Capacity;
     * DEC - Derate Capacity
     */
    val marketServiceType: String,

    val AllocationResult: String,

    val RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AllocationResultValues]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AllocationResultValues
extends
    Parseable[AllocationResultValues]
{
    val sup = BasicElement.parse _
    val aggregateType = parse_element (element ("""AllocationResultValues.aggregateType"""))_
    val allocationMwHour = parse_element (element ("""AllocationResultValues.allocationMwHour"""))_
    val allocationPrice = parse_element (element ("""AllocationResultValues.allocationPrice"""))_
    val energyTypeCode = parse_element (element ("""AllocationResultValues.energyTypeCode"""))_
    val marketServiceType = parse_element (element ("""AllocationResultValues.marketServiceType"""))_
    val AllocationResult = parse_attribute (attribute ("""AllocationResultValues.AllocationResult"""))_
    val RegisteredResource = parse_attribute (attribute ("""AllocationResultValues.RegisteredResource"""))_
    def parse (context: Context): AllocationResultValues =
    {
        AllocationResultValues(
            sup (context),
            aggregateType (context),
            toDouble (allocationMwHour (context), context),
            toDouble (allocationPrice (context), context),
            energyTypeCode (context),
            marketServiceType (context),
            AllocationResult (context),
            RegisteredResource (context)
        )
    }
}

/**
 * Models Market clearing results for Auxillary costs
 */
case class AuxiliaryCost
(

    override val sup: BasicElement,

    val intervalStartTime: String,

    val marketType: String,

    val updateTimeStamp: String,

    val updateUser: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AuxiliaryCost]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AuxiliaryCost
extends
    Parseable[AuxiliaryCost]
{
    val sup = BasicElement.parse _
    val intervalStartTime = parse_element (element ("""AuxiliaryCost.intervalStartTime"""))_
    val marketType = parse_attribute (attribute ("""AuxiliaryCost.marketType"""))_
    val updateTimeStamp = parse_element (element ("""AuxiliaryCost.updateTimeStamp"""))_
    val updateUser = parse_element (element ("""AuxiliaryCost.updateUser"""))_
    def parse (context: Context): AuxiliaryCost =
    {
        AuxiliaryCost(
            sup (context),
            intervalStartTime (context),
            marketType (context),
            updateTimeStamp (context),
            updateUser (context)
        )
    }
}

/**
 * Models Auxillary Values
 */
case class AuxiliaryObject
(

    override val sup: BasicElement,

    val RegisteredGenerator: String,

    val RegisteredLoad: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AuxiliaryObject]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AuxiliaryObject
extends
    Parseable[AuxiliaryObject]
{
    val sup = BasicElement.parse _
    val RegisteredGenerator = parse_attribute (attribute ("""AuxiliaryObject.RegisteredGenerator"""))_
    val RegisteredLoad = parse_attribute (attribute ("""AuxiliaryObject.RegisteredLoad"""))_
    def parse (context: Context): AuxiliaryObject =
    {
        AuxiliaryObject(
            sup (context),
            RegisteredGenerator (context),
            RegisteredLoad (context)
        )
    }
}

/**
 * Models Auxillary Values
 */
case class AuxiliaryValues
(

    override val sup: AuxiliaryObject,

    val availUndispatchedQ: Double,

    val incrementalORAvail: Double,

    val maxExpostCapacity: Double,

    val minExpostCapacity: Double,

    val noLoadCost: Double,

    val noLoadCostEligibilityFlag: String,

    val startUpCost: Double,

    val startUpCostEligibilityFlag: String,

    val AuxillaryCost: String,

    val FiveMinAuxillaryData: String,

    val TenMinAuxillaryData: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, null, null, null, null) }
    def AuxiliaryObject: AuxiliaryObject = sup.asInstanceOf[AuxiliaryObject]
    override def copy (): Row = { return (clone ().asInstanceOf[AuxiliaryValues]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AuxiliaryValues
extends
    Parseable[AuxiliaryValues]
{
    val sup = AuxiliaryObject.parse _
    val availUndispatchedQ = parse_element (element ("""AuxiliaryValues.availUndispatchedQ"""))_
    val incrementalORAvail = parse_element (element ("""AuxiliaryValues.incrementalORAvail"""))_
    val maxExpostCapacity = parse_element (element ("""AuxiliaryValues.maxExpostCapacity"""))_
    val minExpostCapacity = parse_element (element ("""AuxiliaryValues.minExpostCapacity"""))_
    val noLoadCost = parse_element (element ("""AuxiliaryValues.noLoadCost"""))_
    val noLoadCostEligibilityFlag = parse_attribute (attribute ("""AuxiliaryValues.noLoadCostEligibilityFlag"""))_
    val startUpCost = parse_element (element ("""AuxiliaryValues.startUpCost"""))_
    val startUpCostEligibilityFlag = parse_attribute (attribute ("""AuxiliaryValues.startUpCostEligibilityFlag"""))_
    val AuxillaryCost = parse_attribute (attribute ("""AuxiliaryValues.AuxillaryCost"""))_
    val FiveMinAuxillaryData = parse_attribute (attribute ("""AuxiliaryValues.FiveMinAuxillaryData"""))_
    val TenMinAuxillaryData = parse_attribute (attribute ("""AuxiliaryValues.TenMinAuxillaryData"""))_
    def parse (context: Context): AuxiliaryValues =
    {
        AuxiliaryValues(
            sup (context),
            toDouble (availUndispatchedQ (context), context),
            toDouble (incrementalORAvail (context), context),
            toDouble (maxExpostCapacity (context), context),
            toDouble (minExpostCapacity (context), context),
            toDouble (noLoadCost (context), context),
            noLoadCostEligibilityFlag (context),
            toDouble (startUpCost (context), context),
            startUpCostEligibilityFlag (context),
            AuxillaryCost (context),
            FiveMinAuxillaryData (context),
            TenMinAuxillaryData (context)
        )
    }
}

/**
 * Model Expected Energy  from Market Clearing, interval based
 */
case class ExpectedEnergy
(

    override val sup: BasicElement,

    val intervalStartTime: String,

    val updateTimeStamp: String,

    val updateUser: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ExpectedEnergy]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExpectedEnergy
extends
    Parseable[ExpectedEnergy]
{
    val sup = BasicElement.parse _
    val intervalStartTime = parse_element (element ("""ExpectedEnergy.intervalStartTime"""))_
    val updateTimeStamp = parse_element (element ("""ExpectedEnergy.updateTimeStamp"""))_
    val updateUser = parse_element (element ("""ExpectedEnergy.updateUser"""))_
    def parse (context: Context): ExpectedEnergy =
    {
        ExpectedEnergy(
            sup (context),
            intervalStartTime (context),
            updateTimeStamp (context),
            updateUser (context)
        )
    }
}

/**
 * Model Expected Energy  from Market Clearing
 */
case class ExpectedEnergyValues
(

    override val sup: BasicElement,

    val energyTypeCode: String,

    val expectedMwh: Double,

    val ExpectedEnergy: String,

    val RegisteredResource: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ExpectedEnergyValues]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExpectedEnergyValues
extends
    Parseable[ExpectedEnergyValues]
{
    val sup = BasicElement.parse _
    val energyTypeCode = parse_element (element ("""ExpectedEnergyValues.energyTypeCode"""))_
    val expectedMwh = parse_element (element ("""ExpectedEnergyValues.expectedMwh"""))_
    val ExpectedEnergy = parse_attribute (attribute ("""ExpectedEnergyValues.ExpectedEnergy"""))_
    val RegisteredResource = parse_attribute (attribute ("""ExpectedEnergyValues.RegisteredResource"""))_
    def parse (context: Context): ExpectedEnergyValues =
    {
        ExpectedEnergyValues(
            sup (context),
            energyTypeCode (context),
            toDouble (expectedMwh (context), context),
            ExpectedEnergy (context),
            RegisteredResource (context)
        )
    }
}

/**
 * Models 5-Minutes Auxillary Data
 */
case class FiveMinAuxiliaryData
(

    override val sup: BasicElement,

    val intervalStartTime: String,

    val updateTimeStamp: String,

    val updateUser: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[FiveMinAuxiliaryData]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FiveMinAuxiliaryData
extends
    Parseable[FiveMinAuxiliaryData]
{
    val sup = BasicElement.parse _
    val intervalStartTime = parse_element (element ("""FiveMinAuxiliaryData.intervalStartTime"""))_
    val updateTimeStamp = parse_element (element ("""FiveMinAuxiliaryData.updateTimeStamp"""))_
    val updateUser = parse_element (element ("""FiveMinAuxiliaryData.updateUser"""))_
    def parse (context: Context): FiveMinAuxiliaryData =
    {
        FiveMinAuxiliaryData(
            sup (context),
            intervalStartTime (context),
            updateTimeStamp (context),
            updateUser (context)
        )
    }
}

/**
 * Models 10-Minutes Auxillary Data
 */
case class TenMinAuxiliaryData
(

    override val sup: BasicElement,

    val intervalStartTime: String,

    val updateTimeStamp: String,

    val updateUser: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TenMinAuxiliaryData]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TenMinAuxiliaryData
extends
    Parseable[TenMinAuxiliaryData]
{
    val sup = BasicElement.parse _
    val intervalStartTime = parse_element (element ("""TenMinAuxiliaryData.intervalStartTime"""))_
    val updateTimeStamp = parse_element (element ("""TenMinAuxiliaryData.updateTimeStamp"""))_
    val updateUser = parse_element (element ("""TenMinAuxiliaryData.updateUser"""))_
    def parse (context: Context): TenMinAuxiliaryData =
    {
        TenMinAuxiliaryData(
            sup (context),
            intervalStartTime (context),
            updateTimeStamp (context),
            updateUser (context)
        )
    }
}

/**
 * Models prices at Trading Hubs, interval based
 */
case class TradingHubPrice
(

    override val sup: BasicElement,

    val intervalStartTime: String,

    val marketType: String,

    val updateTimeStamp: String,

    val updateUser: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TradingHubPrice]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TradingHubPrice
extends
    Parseable[TradingHubPrice]
{
    val sup = BasicElement.parse _
    val intervalStartTime = parse_element (element ("""TradingHubPrice.intervalStartTime"""))_
    val marketType = parse_attribute (attribute ("""TradingHubPrice.marketType"""))_
    val updateTimeStamp = parse_element (element ("""TradingHubPrice.updateTimeStamp"""))_
    val updateUser = parse_element (element ("""TradingHubPrice.updateUser"""))_
    def parse (context: Context): TradingHubPrice =
    {
        TradingHubPrice(
            sup (context),
            intervalStartTime (context),
            marketType (context),
            updateTimeStamp (context),
            updateUser (context)
        )
    }
}

/**
 * Models prices at Trading Hubs
 */
case class TradingHubValues
(

    override val sup: BasicElement,

    /**
     * Utilizes the Market type.
     * For DA, the price is hourly. For RTM the price is a 5 minute price.
     */
    val price: Double,

    val AggregatedPnode: String,

    val TradingHubPrice: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TradingHubValues]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TradingHubValues
extends
    Parseable[TradingHubValues]
{
    val sup = BasicElement.parse _
    val price = parse_element (element ("""TradingHubValues.price"""))_
    val AggregatedPnode = parse_attribute (attribute ("""TradingHubValues.AggregatedPnode"""))_
    val TradingHubPrice = parse_attribute (attribute ("""TradingHubValues.TradingHubPrice"""))_
    def parse (context: Context): TradingHubValues =
    {
        TradingHubValues(
            sup (context),
            toDouble (price (context), context),
            AggregatedPnode (context),
            TradingHubPrice (context)
        )
    }
}

object _MarketQualitySystem
{
    def register: Unit =
    {
        AllocationResult.register
        AllocationResultValues.register
        AuxiliaryCost.register
        AuxiliaryObject.register
        AuxiliaryValues.register
        ExpectedEnergy.register
        ExpectedEnergyValues.register
        FiveMinAuxiliaryData.register
        TenMinAuxiliaryData.register
        TradingHubPrice.register
        TradingHubValues.register
    }
}