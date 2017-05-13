package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
 */

/**
 * Model that describes the Congestion Revenue Rights Auction Market
 */
case class CRRMarket
(

    override val sup: Market,

    /**
     * labelID - an ID for a set of apnodes/pnodes used in a CRR market
     */
    val labelID: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Market: Market = sup.asInstanceOf[Market]
    override def copy (): Row = { return (clone ().asInstanceOf[CRRMarket]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CRRMarket
extends
    Parseable[CRRMarket]
{
    val sup = Market.parse _
    val labelID = parse_element (element ("""CRRMarket.labelID"""))_
    def parse (context: Context): CRRMarket =
    {
        CRRMarket(
            sup (context),
            labelID (context)
        )
    }
}

/**
 * Energy and Ancillary Market (e.g.
 * Energy, Spinning Reserve, Non-Spinning Reserve) with a description of the Market operation control parameters.
 */
case class EnergyMarket
(

    override val sup: Market,

    val MarketResults: String,

    val RTO: String,

    val RegisteredResources: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, List()) }
    def Market: Market = sup.asInstanceOf[Market]
    override def copy (): Row = { return (clone ().asInstanceOf[EnergyMarket]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnergyMarket
extends
    Parseable[EnergyMarket]
{
    val sup = Market.parse _
    val MarketResults = parse_attribute (attribute ("""EnergyMarket.MarketResults"""))_
    val RTO = parse_attribute (attribute ("""EnergyMarket.RTO"""))_
    val RegisteredResources = parse_attributes (attribute ("""EnergyMarket.RegisteredResources"""))_
    def parse (context: Context): EnergyMarket =
    {
        EnergyMarket(
            sup (context),
            MarketResults (context),
            RTO (context),
            RegisteredResources (context)
        )
    }
}

/**
 * Market (e.g.
 * Day Ahead Market, RealTime Market) with a description of the the Market operation control parameters.
 */
case class Market
(

    override val sup: IdentifiedObject,

    /**
     * Market ending time - actual market end
     */
    val actualEnd: String,

    /**
     * Market starting time - actual market start
     */
    val actualStart: String,

    /**
     * True if daylight savings time (DST) is in effect.
     */
    val dst: Boolean,

    /**
     * Market end time.
     */
    val end: String,

    /**
     * Local time zone.
     */
    val localTimeZone: String,

    /**
     * Market start time.
     */
    val start: String,

    /**
     * Market Status
     * 'OPEN', 'CLOSED', 'CLEARED', 'BLOCKED'
     */
    val status: String,

    /**
     * Trading time interval length.
     */
    val timeIntervalLength: Double,

    /**
     * Market trading date
     */
    val tradingDay: String,

    /**
     * Trading period that describes the market, possibilities could be for an Energy Market:
    Day
    Hour
    
    For a CRR Market:
    Year
    Month
     * Season
     */
    val tradingPeriod: String
)
extends
    Element
{
    def this () = { this (null, null, null, false, null, null, null, null, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Market]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Market
extends
    Parseable[Market]
{
    val sup = IdentifiedObject.parse _
    val actualEnd = parse_element (element ("""Market.actualEnd"""))_
    val actualStart = parse_element (element ("""Market.actualStart"""))_
    val dst = parse_element (element ("""Market.dst"""))_
    val end = parse_element (element ("""Market.end"""))_
    val localTimeZone = parse_element (element ("""Market.localTimeZone"""))_
    val start = parse_element (element ("""Market.start"""))_
    val status = parse_element (element ("""Market.status"""))_
    val timeIntervalLength = parse_element (element ("""Market.timeIntervalLength"""))_
    val tradingDay = parse_element (element ("""Market.tradingDay"""))_
    val tradingPeriod = parse_element (element ("""Market.tradingPeriod"""))_
    def parse (context: Context): Market =
    {
        Market(
            sup (context),
            actualEnd (context),
            actualStart (context),
            toBoolean (dst (context), context),
            end (context),
            localTimeZone (context),
            start (context),
            status (context),
            toDouble (timeIntervalLength (context), context),
            tradingDay (context),
            tradingPeriod (context)
        )
    }
}

/**
 * This class represent the actual instance of an event.
 */
case class MarketActualEvent
(

    override val sup: BasicElement,

    /**
     * Description of the event.
     */
    val description: String,

    /**
     * Actual event ID.
     */
    val eventID: String,

    /**
     * Start time of the event.
     */
    val eventTime: String,

    /**
     * Market run triggered by this actual event.
     * For example, the DA run is triggered by the actual open bid submission event and terminated by the actual close bid submission event.
     */
    val MarketRun: String,

    /**
     * Planned event executed by this actual event.
     */
    val PlannedMarketEvent: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketActualEvent]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketActualEvent
extends
    Parseable[MarketActualEvent]
{
    val sup = BasicElement.parse _
    val description = parse_element (element ("""MarketActualEvent.description"""))_
    val eventID = parse_element (element ("""MarketActualEvent.eventID"""))_
    val eventTime = parse_element (element ("""MarketActualEvent.eventTime"""))_
    val MarketRun = parse_attribute (attribute ("""MarketActualEvent.MarketRun"""))_
    val PlannedMarketEvent = parse_attribute (attribute ("""MarketActualEvent.PlannedMarketEvent"""))_
    def parse (context: Context): MarketActualEvent =
    {
        MarketActualEvent(
            sup (context),
            description (context),
            eventID (context),
            eventTime (context),
            MarketRun (context),
            PlannedMarketEvent (context)
        )
    }
}

/**
 * Aggregation of market information relative for a specific time interval.
 */
case class MarketFactors
(

    override val sup: Document,

    /**
     * The end of the time interval for which requirement is defined.
     */
    val intervalEndTime: String,

    /**
     * The start of the time interval for which requirement is defined.
     */
    val intervalStartTime: String,

    val Market: String,

    val MktActivityRecord: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketFactors]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketFactors
extends
    Parseable[MarketFactors]
{
    val sup = Document.parse _
    val intervalEndTime = parse_element (element ("""MarketFactors.intervalEndTime"""))_
    val intervalStartTime = parse_element (element ("""MarketFactors.intervalStartTime"""))_
    val Market = parse_attribute (attribute ("""MarketFactors.Market"""))_
    val MktActivityRecord = parse_attributes (attribute ("""MarketFactors.MktActivityRecord"""))_
    def parse (context: Context): MarketFactors =
    {
        MarketFactors(
            sup (context),
            intervalEndTime (context),
            intervalStartTime (context),
            Market (context),
            MktActivityRecord (context)
        )
    }
}

/**
 * This class identifies a set of planned markets.
 * This class is a container of these planned markets
 */
case class MarketPlan
(

    override val sup: BasicElement,

    /**
     * Description of the planned market.
     */
    val description: String,

    /**
     * Planned market identifier.
     */
    val marketPlanID: String,

    /**
     * Name of the planned market.
     */
    val name: String,

    /**
     * Planned market trading day.
     */
    val tradingDay: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketPlan]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketPlan
extends
    Parseable[MarketPlan]
{
    val sup = BasicElement.parse _
    val description = parse_element (element ("""MarketPlan.description"""))_
    val marketPlanID = parse_element (element ("""MarketPlan.marketPlanID"""))_
    val name = parse_element (element ("""MarketPlan.name"""))_
    val tradingDay = parse_element (element ("""MarketPlan.tradingDay"""))_
    def parse (context: Context): MarketPlan =
    {
        MarketPlan(
            sup (context),
            description (context),
            marketPlanID (context),
            name (context),
            tradingDay (context)
        )
    }
}

/**
 * A product traded by an RTO (e.g. energy, 10 minute spinning reserve).
 * Ancillary service product examples include:Regulation UpRegulation DnSpinning ReserveNon-Spinning ReserveOperating Reserve
 */
case class MarketProduct
(

    override val sup: IdentifiedObject,

    /**
     * Market product type examples:
    
    EN (Energy)
    RU (Regulation Up)
    RD (Regulation Dn)
    SR (Spinning Reserve)
    NR (Non-Spinning Reserve)
     * RC (RUC)
     */
    val marketProductType: String,

    /**
     * Ramping time interval for the specific market product type specified by marketProductType attribute.
     * For example, if marketProductType = EN (from enumeration MarketProductType), then the rampInterval is the ramping time interval for Energy.
     */
    val rampInterval: Double,

    val Market: String,

    val MarketRegionResults: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketProduct]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketProduct
extends
    Parseable[MarketProduct]
{
    val sup = IdentifiedObject.parse _
    val marketProductType = parse_attribute (attribute ("""MarketProduct.marketProductType"""))_
    val rampInterval = parse_element (element ("""MarketProduct.rampInterval"""))_
    val Market = parse_attribute (attribute ("""MarketProduct.Market"""))_
    val MarketRegionResults = parse_attribute (attribute ("""MarketProduct.MarketRegionResults"""))_
    def parse (context: Context): MarketProduct =
    {
        MarketProduct(
            sup (context),
            marketProductType (context),
            toDouble (rampInterval (context), context),
            Market (context),
            MarketRegionResults (context)
        )
    }
}

/**
 * This class represent an actual instance of a planned market.
 * For example, a Day Ahead market opens with the Bid Submission, ends with the closing of the Bid Submission. The market run represent the whole process. MarketRuns can be defined for markets such as Day Ahead Market, Real Time Market, Hour Ahead Market, Week Ahead Market,...
 */
case class MarketRun
(

    override val sup: BasicElement,

    /**
     * The execution type; Day Ahead, Intra Day, Real Time Pre-Dispatch, Real Time Dispatch
     */
    val executionType: String,

    /**
     * Approved time for case.
     * Identifies the time that the dispatcher approved a specific real time unit dispatch case
     */
    val marketApprovalTime: String,

    /**
     * Set to true when the plan is approved by authority and becomes the official plan for the day ahead market.
     * Identifies the approved case for the market for the specified time interval.
     */
    val marketApprovedStatus: Boolean,

    /**
     * The end time defined as the end of the market, market end time.
     */
    val marketEndTime: String,

    /**
     * An identification that defines the attributes of the Market.
     * In todays terms: Market Type: DA, RTM, Trade Date:  1/25/04, Trade Hour: 1-25
     */
    val marketID: String,

    /**
     * A unique identifier that differentiates the different runs of the same Market ID.
     * More specifically, if the market is re-opened and re-closed and rerun completely, the first set of results and the second set of results produced will have the same Market ID but will have different Market Run IDs since the multiple run is for the same market.
     */
    val marketRunID: String,

    /**
     * The start time defined as the beginning of the market, market start time.
     */
    val marketStartTime: String,

    /**
     * The market type, Day Ahead Market or Real Time Market.
     */
    val marketType: String,

    /**
     * This is the state of market run activitie as reported by market systems to the market definition services.
     */
    val reportedState: String,

    /**
     * This is the state controlled by market defintion service.
     * possible values could be but not limited by: Open, Close.
     */
    val runState: String,

    val Market: String,

    /**
     * A planned market could have multiple market runs for the reason that a planned market could have a rerun.
     */
    val PlannedMarket: String
)
extends
    Element
{
    def this () = { this (null, null, null, false, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketRun]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketRun
extends
    Parseable[MarketRun]
{
    val sup = BasicElement.parse _
    val executionType = parse_attribute (attribute ("""MarketRun.executionType"""))_
    val marketApprovalTime = parse_element (element ("""MarketRun.marketApprovalTime"""))_
    val marketApprovedStatus = parse_element (element ("""MarketRun.marketApprovedStatus"""))_
    val marketEndTime = parse_element (element ("""MarketRun.marketEndTime"""))_
    val marketID = parse_element (element ("""MarketRun.marketID"""))_
    val marketRunID = parse_element (element ("""MarketRun.marketRunID"""))_
    val marketStartTime = parse_element (element ("""MarketRun.marketStartTime"""))_
    val marketType = parse_attribute (attribute ("""MarketRun.marketType"""))_
    val reportedState = parse_element (element ("""MarketRun.reportedState"""))_
    val runState = parse_element (element ("""MarketRun.runState"""))_
    val Market = parse_attribute (attribute ("""MarketRun.Market"""))_
    val PlannedMarket = parse_attribute (attribute ("""MarketRun.PlannedMarket"""))_
    def parse (context: Context): MarketRun =
    {
        MarketRun(
            sup (context),
            executionType (context),
            marketApprovalTime (context),
            toBoolean (marketApprovedStatus (context), context),
            marketEndTime (context),
            marketID (context),
            marketRunID (context),
            marketStartTime (context),
            marketType (context),
            reportedState (context),
            runState (context),
            Market (context),
            PlannedMarket (context)
        )
    }
}

/**
 * Represent a planned market.
 * For example an planned DA/HA/RT market.
 */
case class PlannedMarket
(

    override val sup: BasicElement,

    /**
     * Market end time.
     */
    val marketEndTime: String,

    /**
     * An identification that defines the attributes of the Market.
     * In todays terms: Market Type: DA, RTM, Trade Date:  1/25/04, Trade Hour: 1-25.
     */
    val marketID: String,

    /**
     * Market start time.
     */
    val marketStartTime: String,

    /**
     * Market type.
     */
    val marketType: String,

    /**
     * a market plan has a number of markets (DA, HA, RT)
     */
    val MarketPlan: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PlannedMarket]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PlannedMarket
extends
    Parseable[PlannedMarket]
{
    val sup = BasicElement.parse _
    val marketEndTime = parse_element (element ("""PlannedMarket.marketEndTime"""))_
    val marketID = parse_element (element ("""PlannedMarket.marketID"""))_
    val marketStartTime = parse_element (element ("""PlannedMarket.marketStartTime"""))_
    val marketType = parse_attribute (attribute ("""PlannedMarket.marketType"""))_
    val MarketPlan = parse_attribute (attribute ("""PlannedMarket.MarketPlan"""))_
    def parse (context: Context): PlannedMarket =
    {
        PlannedMarket(
            sup (context),
            marketEndTime (context),
            marketID (context),
            marketStartTime (context),
            marketType (context),
            MarketPlan (context)
        )
    }
}

/**
 * This class represents planned events.
 * Used to model the various planned events in a market (closing time, clearing time, etc).
 */
case class PlannedMarketEvent
(

    override val sup: BasicElement,

    /**
     * Description of the planned event.
     */
    val description: String,

    /**
     * Planned event type.
     */
    val eventType: String,

    /**
     * Planned event identifier.
     */
    val plannedEventID: String,

    /**
     * This is relative time so that this attribute can be used by more than one planned market.
     * For example the bid submission is 10am everyday.
     */
    val plannedTime: Int
)
extends
    Element
{
    def this () = { this (null, null, null, null, 0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PlannedMarketEvent]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PlannedMarketEvent
extends
    Parseable[PlannedMarketEvent]
{
    val sup = BasicElement.parse _
    val description = parse_element (element ("""PlannedMarketEvent.description"""))_
    val eventType = parse_element (element ("""PlannedMarketEvent.eventType"""))_
    val plannedEventID = parse_element (element ("""PlannedMarketEvent.plannedEventID"""))_
    val plannedTime = parse_element (element ("""PlannedMarketEvent.plannedTime"""))_
    def parse (context: Context): PlannedMarketEvent =
    {
        PlannedMarketEvent(
            sup (context),
            description (context),
            eventType (context),
            plannedEventID (context),
            toInteger (plannedTime (context), context)
        )
    }
}

object _MarketPlan
{
    def register: Unit =
    {
        CRRMarket.register
        EnergyMarket.register
        Market.register
        MarketActualEvent.register
        MarketFactors.register
        MarketPlan.register
        MarketProduct.register
        MarketRun.register
        PlannedMarket.register
        PlannedMarketEvent.register
    }
}