package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/*
 * Package: Metering
 */

case class BaseReading
(
    override val sup: MeasurementValue,
    val reportedDateTime: String,
    val source: String,
    val value: String,
    val timePeriod: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def MeasurementValue: MeasurementValue = sup.asInstanceOf[MeasurementValue]
    override def copy (): Row = { return (clone ().asInstanceOf[BaseReading]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BaseReading
extends
    Parseable[BaseReading]
{
    val reportedDateTime = parse_element (element ("""BaseReading.reportedDateTime"""))
    val source = parse_element (element ("""BaseReading.source"""))
    val value = parse_element (element ("""BaseReading.value"""))
    val timePeriod = parse_attribute (attribute ("""BaseReading.timePeriod"""))
    def parse (context: Context): BaseReading =
    {
        return (
            BaseReading
            (
                MeasurementValue.parse (context),
                reportedDateTime (context),
                source (context),
                value (context),
                timePeriod (context)
            )
        )
    }
}

case class Channel
(
    override val sup: IdentifiedObject,
    val isVirtual: Boolean,
    val ReadingType: String,
    val Register: String
)
extends
    Element
{
    def this () = { this (null, false, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Channel]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Channel
extends
    Parseable[Channel]
{
    val isVirtual = parse_element (element ("""Channel.isVirtual"""))
    val ReadingType = parse_attribute (attribute ("""Channel.ReadingType"""))
    val Register = parse_attribute (attribute ("""Channel.Register"""))
    def parse (context: Context): Channel =
    {
        return (
            Channel
            (
                IdentifiedObject.parse (context),
                toBoolean (isVirtual (context), context),
                ReadingType (context),
                Register (context)
            )
        )
    }
}

case class ComFunction
(
    override val sup: EndDeviceFunction,
    val amrAddress: String,
    val amrRouter: String,
    val direction: String,
    val technology: String,
    val ComModule: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def EndDeviceFunction: EndDeviceFunction = sup.asInstanceOf[EndDeviceFunction]
    override def copy (): Row = { return (clone ().asInstanceOf[ComFunction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ComFunction
extends
    Parseable[ComFunction]
{
    val amrAddress = parse_element (element ("""ComFunction.amrAddress"""))
    val amrRouter = parse_element (element ("""ComFunction.amrRouter"""))
    val direction = parse_attribute (attribute ("""ComFunction.direction"""))
    val technology = parse_attribute (attribute ("""ComFunction.technology"""))
    val ComModule = parse_attribute (attribute ("""ComFunction.ComModule"""))
    def parse (context: Context): ComFunction =
    {
        return (
            ComFunction
            (
                EndDeviceFunction.parse (context),
                amrAddress (context),
                amrRouter (context),
                direction (context),
                technology (context),
                ComModule (context)
            )
        )
    }
}

case class ComModule
(
    override val sup: Asset,
    val amrSystem: String,
    val supportsAutonomousDst: Boolean,
    val timeZoneOffset: Double
)
extends
    Element
{
    def this () = { this (null, null, false, 0.0) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { return (clone ().asInstanceOf[ComModule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ComModule
extends
    Parseable[ComModule]
{
    val amrSystem = parse_element (element ("""ComModule.amrSystem"""))
    val supportsAutonomousDst = parse_element (element ("""ComModule.supportsAutonomousDst"""))
    val timeZoneOffset = parse_element (element ("""ComModule.timeZoneOffset"""))
    def parse (context: Context): ComModule =
    {
        return (
            ComModule
            (
                Asset.parse (context),
                amrSystem (context),
                toBoolean (supportsAutonomousDst (context), context),
                toDouble (timeZoneOffset (context), context)
            )
        )
    }
}

case class ControlledAppliance
(
    override val sup: BasicElement,
    val isElectricVehicle: Boolean,
    val isExteriorLighting: Boolean,
    val isGenerationSystem: Boolean,
    val isHvacCompressorOrFurnace: Boolean,
    val isInteriorLighting: Boolean,
    val isIrrigationPump: Boolean,
    val isManagedCommercialIndustrialLoad: Boolean,
    val isPoolPumpSpaJacuzzi: Boolean,
    val isSimpleMiscLoad: Boolean,
    val isSmartAppliance: Boolean,
    val isStripAndBaseboardHeater: Boolean,
    val isWaterHeater: Boolean
)
extends
    Element
{
    def this () = { this (null, false, false, false, false, false, false, false, false, false, false, false, false) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ControlledAppliance]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ControlledAppliance
extends
    Parseable[ControlledAppliance]
{
    val isElectricVehicle = parse_element (element ("""ControlledAppliance.isElectricVehicle"""))
    val isExteriorLighting = parse_element (element ("""ControlledAppliance.isExteriorLighting"""))
    val isGenerationSystem = parse_element (element ("""ControlledAppliance.isGenerationSystem"""))
    val isHvacCompressorOrFurnace = parse_element (element ("""ControlledAppliance.isHvacCompressorOrFurnace"""))
    val isInteriorLighting = parse_element (element ("""ControlledAppliance.isInteriorLighting"""))
    val isIrrigationPump = parse_element (element ("""ControlledAppliance.isIrrigationPump"""))
    val isManagedCommercialIndustrialLoad = parse_element (element ("""ControlledAppliance.isManagedCommercialIndustrialLoad"""))
    val isPoolPumpSpaJacuzzi = parse_element (element ("""ControlledAppliance.isPoolPumpSpaJacuzzi"""))
    val isSimpleMiscLoad = parse_element (element ("""ControlledAppliance.isSimpleMiscLoad"""))
    val isSmartAppliance = parse_element (element ("""ControlledAppliance.isSmartAppliance"""))
    val isStripAndBaseboardHeater = parse_element (element ("""ControlledAppliance.isStripAndBaseboardHeater"""))
    val isWaterHeater = parse_element (element ("""ControlledAppliance.isWaterHeater"""))
    def parse (context: Context): ControlledAppliance =
    {
        return (
            ControlledAppliance
            (
                BasicElement.parse (context),
                toBoolean (isElectricVehicle (context), context),
                toBoolean (isExteriorLighting (context), context),
                toBoolean (isGenerationSystem (context), context),
                toBoolean (isHvacCompressorOrFurnace (context), context),
                toBoolean (isInteriorLighting (context), context),
                toBoolean (isIrrigationPump (context), context),
                toBoolean (isManagedCommercialIndustrialLoad (context), context),
                toBoolean (isPoolPumpSpaJacuzzi (context), context),
                toBoolean (isSimpleMiscLoad (context), context),
                toBoolean (isSmartAppliance (context), context),
                toBoolean (isStripAndBaseboardHeater (context), context),
                toBoolean (isWaterHeater (context), context)
            )
        )
    }
}

case class DemandResponseProgram
(
    override val sup: IdentifiedObject,
    val typ: String, // type
    val validityInterval: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[DemandResponseProgram]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DemandResponseProgram
extends
    Parseable[DemandResponseProgram]
{
    val typ = parse_element (element ("""DemandResponseProgram.typ"""))
    val validityInterval = parse_attribute (attribute ("""DemandResponseProgram.validityInterval"""))
    def parse (context: Context): DemandResponseProgram =
    {
        return (
            DemandResponseProgram
            (
                IdentifiedObject.parse (context),
                typ (context),
                validityInterval (context)
            )
        )
    }
}

case class EndDevice
(
    override val sup: AssetContainer,
    val amrSystem: String,
    val installCode: String,
    val isPan: Boolean,
    val isVirtual: Boolean,
    val timeZoneOffset: Double,
    val Customer: String,
    val EndDeviceInfo: String,
    val ServiceLocation: String,
    val UsagePoint: String
)
extends
    Element
{
    def this () = { this (null, null, null, false, false, 0.0, null, null, null, null) }
    def AssetContainer: AssetContainer = sup.asInstanceOf[AssetContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDevice]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDevice
extends
    Parseable[EndDevice]
{
    val amrSystem = parse_element (element ("""EndDevice.amrSystem"""))
    val installCode = parse_element (element ("""EndDevice.installCode"""))
    val isPan = parse_element (element ("""EndDevice.isPan"""))
    val isVirtual = parse_element (element ("""EndDevice.isVirtual"""))
    val timeZoneOffset = parse_element (element ("""EndDevice.timeZoneOffset"""))
    val Customer = parse_attribute (attribute ("""EndDevice.Customer"""))
    val EndDeviceInfo = parse_attribute (attribute ("""EndDevice.EndDeviceInfo"""))
    val ServiceLocation = parse_attribute (attribute ("""EndDevice.ServiceLocation"""))
    val UsagePoint = parse_attribute (attribute ("""EndDevice.UsagePoint"""))
    def parse (context: Context): EndDevice =
    {
        return (
            EndDevice
            (
                AssetContainer.parse (context),
                amrSystem (context),
                installCode (context),
                toBoolean (isPan (context), context),
                toBoolean (isVirtual (context), context),
                toDouble (timeZoneOffset (context), context),
                Customer (context),
                EndDeviceInfo (context),
                ServiceLocation (context),
                UsagePoint (context)
            )
        )
    }
}

case class EndDeviceAction
(
    override val sup: BasicElement,
    val command: String,
    val duration: Double,
    val durationIndefinite: Boolean,
    val startDateTime: String,
    val EndDeviceControl: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, false, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceAction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceAction
extends
    Parseable[EndDeviceAction]
{
    val command = parse_element (element ("""EndDeviceAction.command"""))
    val duration = parse_element (element ("""EndDeviceAction.duration"""))
    val durationIndefinite = parse_element (element ("""EndDeviceAction.durationIndefinite"""))
    val startDateTime = parse_element (element ("""EndDeviceAction.startDateTime"""))
    val EndDeviceControl = parse_attribute (attribute ("""EndDeviceAction.EndDeviceControl"""))
    def parse (context: Context): EndDeviceAction =
    {
        return (
            EndDeviceAction
            (
                BasicElement.parse (context),
                command (context),
                toDouble (duration (context), context),
                toBoolean (durationIndefinite (context), context),
                startDateTime (context),
                EndDeviceControl (context)
            )
        )
    }
}

case class EndDeviceCapability
(
    override val sup: BasicElement,
    val autonomousDst: Boolean,
    val communication: Boolean,
    val connectDisconnect: Boolean,
    val demandResponse: Boolean,
    val electricMetering: Boolean,
    val gasMetering: Boolean,
    val metrolgy: Boolean,
    val onRequestRead: Boolean,
    val outageHistory: Boolean,
    val pressureCompensation: Boolean,
    val pricingInfo: Boolean,
    val pulseOutput: Boolean,
    val relaysProgramming: Boolean,
    val reverseFlow: Boolean,
    val superCompressibilityCompensation: Boolean,
    val temperatureCompensation: Boolean,
    val textMessage: Boolean,
    val waterMetering: Boolean
)
extends
    Element
{
    def this () = { this (null, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceCapability]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceCapability
extends
    Parseable[EndDeviceCapability]
{
    val autonomousDst = parse_element (element ("""EndDeviceCapability.autonomousDst"""))
    val communication = parse_element (element ("""EndDeviceCapability.communication"""))
    val connectDisconnect = parse_element (element ("""EndDeviceCapability.connectDisconnect"""))
    val demandResponse = parse_element (element ("""EndDeviceCapability.demandResponse"""))
    val electricMetering = parse_element (element ("""EndDeviceCapability.electricMetering"""))
    val gasMetering = parse_element (element ("""EndDeviceCapability.gasMetering"""))
    val metrolgy = parse_element (element ("""EndDeviceCapability.metrolgy"""))
    val onRequestRead = parse_element (element ("""EndDeviceCapability.onRequestRead"""))
    val outageHistory = parse_element (element ("""EndDeviceCapability.outageHistory"""))
    val pressureCompensation = parse_element (element ("""EndDeviceCapability.pressureCompensation"""))
    val pricingInfo = parse_element (element ("""EndDeviceCapability.pricingInfo"""))
    val pulseOutput = parse_element (element ("""EndDeviceCapability.pulseOutput"""))
    val relaysProgramming = parse_element (element ("""EndDeviceCapability.relaysProgramming"""))
    val reverseFlow = parse_element (element ("""EndDeviceCapability.reverseFlow"""))
    val superCompressibilityCompensation = parse_element (element ("""EndDeviceCapability.superCompressibilityCompensation"""))
    val temperatureCompensation = parse_element (element ("""EndDeviceCapability.temperatureCompensation"""))
    val textMessage = parse_element (element ("""EndDeviceCapability.textMessage"""))
    val waterMetering = parse_element (element ("""EndDeviceCapability.waterMetering"""))
    def parse (context: Context): EndDeviceCapability =
    {
        return (
            EndDeviceCapability
            (
                BasicElement.parse (context),
                toBoolean (autonomousDst (context), context),
                toBoolean (communication (context), context),
                toBoolean (connectDisconnect (context), context),
                toBoolean (demandResponse (context), context),
                toBoolean (electricMetering (context), context),
                toBoolean (gasMetering (context), context),
                toBoolean (metrolgy (context), context),
                toBoolean (onRequestRead (context), context),
                toBoolean (outageHistory (context), context),
                toBoolean (pressureCompensation (context), context),
                toBoolean (pricingInfo (context), context),
                toBoolean (pulseOutput (context), context),
                toBoolean (relaysProgramming (context), context),
                toBoolean (reverseFlow (context), context),
                toBoolean (superCompressibilityCompensation (context), context),
                toBoolean (temperatureCompensation (context), context),
                toBoolean (textMessage (context), context),
                toBoolean (waterMetering (context), context)
            )
        )
    }
}

case class EndDeviceControl
(
    override val sup: IdentifiedObject,
    val drProgramLevel: Int,
    val drProgramMandatory: Boolean,
    val issuerID: String,
    val issuerTrackingID: String,
    val reason: String,
    val EndDeviceAction: String,
    val EndDeviceControlType: String,
    val priceSignal: Double,
    val primaryDeviceTiming: String,
    val scheduledInterval: String,
    val secondaryDeviceTiming: String
)
extends
    Element
{
    def this () = { this (null, 0, false, null, null, null, null, null, 0.0, null, null, null ) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceControl]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceControl
extends
    Parseable[EndDeviceControl]
{
    val drProgramLevel = parse_element (element ("""EndDeviceControl.drProgramLevel"""))
    val drProgramMandatory = parse_element (element ("""EndDeviceControl.drProgramMandatory"""))
    val issuerID = parse_element (element ("""EndDeviceControl.issuerID"""))
    val issuerTrackingID = parse_element (element ("""EndDeviceControl.issuerTrackingID"""))
    val reason = parse_element (element ("""EndDeviceControl.reason"""))
    val EndDeviceAction = parse_attribute (attribute ("""EndDeviceControl.EndDeviceAction"""))
    val EndDeviceControlType = parse_attribute (attribute ("""EndDeviceControl.EndDeviceControlType"""))
    val priceSignal = parse_attribute (attribute ("""EndDeviceControl.priceSignal"""))
    val primaryDeviceTiming = parse_attribute (attribute ("""EndDeviceControl.primaryDeviceTiming"""))
    val scheduledInterval = parse_attribute (attribute ("""EndDeviceControl.scheduledInterval"""))
    val secondaryDeviceTiming = parse_attribute (attribute ("""EndDeviceControl.secondaryDeviceTiming"""))
    def parse (context: Context): EndDeviceControl =
    {
        return (
            EndDeviceControl
            (
                IdentifiedObject.parse (context),
                toInteger (drProgramLevel (context), context),
                toBoolean (drProgramMandatory (context), context),
                issuerID (context),
                issuerTrackingID (context),
                reason (context),
                EndDeviceAction (context),
                EndDeviceControlType (context),
                toDouble (priceSignal (context), context),
                primaryDeviceTiming (context),
                scheduledInterval (context),
                secondaryDeviceTiming (context)
            )
        )
    }
}

case class EndDeviceControlType
(
    override val sup: IdentifiedObject,
    val domain: String,
    val eventOrAction: String,
    val subDomain: String,
    val typ: String  // type
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceControlType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceControlType
extends
    Parseable[EndDeviceControlType]
{
    val domain = parse_element (element ("""EndDeviceControlType.domain"""))
    val eventOrAction = parse_element (element ("""EndDeviceControlType.eventOrAction"""))
    val subDomain = parse_element (element ("""EndDeviceControlType.subDomain"""))
    val typ = parse_element (element ("""EndDeviceControlType.typ"""))
    def parse (context: Context): EndDeviceControlType =
    {
        return (
            EndDeviceControlType
            (
                IdentifiedObject.parse (context),
                domain (context),
                eventOrAction (context),
                subDomain (context),
                typ (context)
            )
        )
    }
}

case class EndDeviceEvent
(
    override val sup: ActivityRecord,
    val issuerID: String,
    val issuerTrackingID: String,
    val userID: String,
    val EndDevice: String,
    val EndDeviceEventType: String,
    val MeterReading: String,
    val UsagePoint: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def ActivityRecord: ActivityRecord = sup.asInstanceOf[ActivityRecord]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceEvent]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceEvent
extends
    Parseable[EndDeviceEvent]
{
    val issuerID = parse_element (element ("""EndDeviceEvent.issuerID"""))
    val issuerTrackingID = parse_element (element ("""EndDeviceEvent.issuerTrackingID"""))
    val userID = parse_element (element ("""EndDeviceEvent.userID"""))
    val EndDevice = parse_attribute (attribute ("""EndDeviceEvent.EndDevice"""))
    val EndDeviceEventType = parse_attribute (attribute ("""EndDeviceEvent.EndDeviceEventType"""))
    val MeterReading = parse_attribute (attribute ("""EndDeviceEvent.MeterReading"""))
    val UsagePoint = parse_attribute (attribute ("""EndDeviceEvent.UsagePoint"""))
    def parse (context: Context): EndDeviceEvent =
    {
        return (
            EndDeviceEvent
            (
                ActivityRecord.parse (context),
                issuerID (context),
                issuerTrackingID (context),
                userID (context),
                EndDevice (context),
                EndDeviceEventType (context),
                MeterReading (context),
                UsagePoint (context)
            )
        )
    }
}

case class EndDeviceEventDetail
(
    override val sup: BasicElement,
    val name: String,
    val EndDeviceEvent: String,
    val value: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceEventDetail]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceEventDetail
extends
    Parseable[EndDeviceEventDetail]
{
    val name = parse_element (element ("""EndDeviceEventDetail.name"""))
    val EndDeviceEvent = parse_attribute (attribute ("""EndDeviceEventDetail.EndDeviceEvent"""))
    val value = parse_attribute (attribute ("""EndDeviceEventDetail.value"""))
    def parse (context: Context): EndDeviceEventDetail =
    {
        return (
            EndDeviceEventDetail
            (
                BasicElement.parse (context),
                name (context),
                EndDeviceEvent (context),
                value (context)
            )
        )
    }
}

case class EndDeviceEventType
(
    override val sup: IdentifiedObject,
    val domain: String,
    val eventOrAction: String,
    val subDomain: String,
    val typ: String  // type
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceEventType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceEventType
extends
    Parseable[EndDeviceEventType]
{
    val domain = parse_element (element ("""EndDeviceEventType.domain"""))
    val eventOrAction = parse_element (element ("""EndDeviceEventType.eventOrAction"""))
    val subDomain = parse_element (element ("""EndDeviceEventType.subDomain"""))
    val typ = parse_element (element ("""EndDeviceEventType.typ"""))
    def parse (context: Context): EndDeviceEventType =
    {
        return (
            EndDeviceEventType
            (
                IdentifiedObject.parse (context),
                domain (context),
                eventOrAction (context),
                subDomain (context),
                typ (context)
            )
        )
    }
}

case class EndDeviceFunction
(
    override val sup: AssetFunction,
    val enabled: Boolean,
    val EndDevice: String
)
extends
    Element
{
    def this () = { this (null, false, null) }
    def AssetFunction: AssetFunction = sup.asInstanceOf[AssetFunction]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceFunction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceFunction
extends
    Parseable[EndDeviceFunction]
{
    val enabled = parse_element (element ("""EndDeviceFunction.enabled"""))
    val EndDevice = parse_attribute (attribute ("""EndDeviceFunction.EndDevice"""))
    def parse (context: Context): EndDeviceFunction =
    {
        return (
            EndDeviceFunction
            (
                AssetFunction.parse (context),
                toBoolean (enabled (context), context),
                EndDevice (context)
            )
        )
    }
}

case class EndDeviceGroup
(
    override val sup: IdentifiedObject,
    val typ: String  // type
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceGroup]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceGroup
extends
    Parseable[EndDeviceGroup]
{
    val typ = parse_element (element ("""EndDeviceGroup.typ"""))
    def parse (context: Context): EndDeviceGroup =
    {
        return (
            EndDeviceGroup
            (
                IdentifiedObject.parse (context),
                typ (context)
            )
        )
    }
}

case class EndDeviceInfo
(
    override val sup: AssetInfo,
    val isSolidState: Boolean,
    val phaseCount: Int,
    val ratedCurrent: Double,
    val ratedVoltage: Double,
    val capability: String    
)
extends
    Element
{
    def this () = { this (null, false, 0, 0.0, 0.0, null) }
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceInfo
extends
    Parseable[EndDeviceInfo]
{
    val isSolidState = parse_element (element ("""EndDeviceInfo.isSolidState"""))
    val phaseCount = parse_element (element ("""EndDeviceInfo.phaseCount"""))
    val ratedCurrent = parse_element (element ("""EndDeviceInfo.ratedCurrent"""))
    val ratedVoltage = parse_element (element ("""EndDeviceInfo.ratedVoltage"""))
    val capability = parse_attribute (attribute ("""EndDeviceInfo.capability"""))
    def parse (context: Context): EndDeviceInfo =
    {
        return (
            EndDeviceInfo
            (
                AssetInfo.parse (context),
                toBoolean (isSolidState (context), context),
                toInteger (phaseCount (context), context),
                toDouble (ratedCurrent (context), context),
                toDouble (ratedVoltage (context), context),
                capability (context)
            )
        )
    }
}

case class EndDeviceTiming
(
    override val sup: BasicElement,
    val duration: Double,
    val durationIndefinite: Boolean,
    val randomisation: String,
    val interval: String
)
extends
    Element
{
    def this () = { this (null, 0.0, false, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EndDeviceTiming]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EndDeviceTiming
extends
    Parseable[EndDeviceTiming]
{
    val duration = parse_element (element ("""EndDeviceTiming.duration"""))
    val durationIndefinite = parse_element (element ("""EndDeviceTiming.durationIndefinite"""))
    val randomisation = parse_attribute (attribute ("""EndDeviceTiming.randomisation"""))
    val interval = parse_attribute (attribute ("""EndDeviceTiming.interval"""))
    def parse (context: Context): EndDeviceTiming =
    {
        return (
            EndDeviceTiming
            (
                BasicElement.parse (context),
                toDouble (duration (context), context),
                toBoolean (durationIndefinite (context), context),
                randomisation (context),
                interval (context)
            )
        )
    }
}

case class IntervalBlock
(
    override val sup: BasicElement,
    val MeterReading: String,
    val PendingCalculation: String,
    val ReadingType: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[IntervalBlock]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IntervalBlock
extends
    Parseable[IntervalBlock]
{
    val MeterReading = parse_attribute (attribute ("""IntervalBlock.ReadingType"""))
    val PendingCalculation = parse_attribute (attribute ("""IntervalBlock.ReadingType"""))
    val ReadingType = parse_attribute (attribute ("""IntervalBlock.ReadingType"""))
    def parse (context: Context): IntervalBlock =
    {
        return (
            IntervalBlock
            (
                BasicElement.parse (context),
                MeterReading (context),
                PendingCalculation (context),
                ReadingType (context)
            )
        )
    }
}

case class IntervalReading
(
    override val sup: BaseReading
)
extends
    Element
{
    def this () = { this (null) }
    def BaseReading: BaseReading = sup.asInstanceOf[BaseReading]
    override def copy (): Row = { return (clone ().asInstanceOf[IntervalReading]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IntervalReading
extends
    Parseable[IntervalReading]
{
    def parse (context: Context): IntervalReading =
    {
        return (
            IntervalReading
            (
                BaseReading.parse (context)
            )
        )
    }
}

case class Meter
(
    override val sup: EndDevice,
    val formNumber: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def EndDevice: EndDevice = sup.asInstanceOf[EndDevice]
    override def copy (): Row = { return (clone ().asInstanceOf[Meter]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Meter
extends
    Parseable[Meter]
{
    val formNumber = parse_element (element ("""Meter.formNumber"""))
    def parse (context: Context): Meter =
    {
        return (
            Meter
            (
                EndDevice.parse (context),
                formNumber (context)
            )
        )
    }
}

case class MeterMultiplier
(
    override val sup: IdentifiedObject,
    val kind: String,
    val value: Double,
    val Meter: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MeterMultiplier]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MeterMultiplier
extends
    Parseable[MeterMultiplier]
{
    val kind = parse_attribute (attribute ("""MeterMultiplier.kind"""))
    val value = parse_element (element ("""MeterMultiplier.value"""))
    val Meter = parse_attribute (attribute ("""MeterMultiplier.Meter"""))
    def parse (context: Context): MeterMultiplier =
    {
        return (
            MeterMultiplier
            (
                IdentifiedObject.parse (context),
                kind (context),
                toDouble (value (context), context),
                Meter (context)
            )
        )
    }
}

case class MeterReading
(
    override val sup: IdentifiedObject,
    val isCoincidentTrigger: Boolean,
    val CustomerAgreement: String,
    val Meter: String,
    val UsagePoint: String,
    val valuesInterval: String
)
extends
    Element
{
    def this () = { this (null, false, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MeterReading]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MeterReading
extends
    Parseable[MeterReading]
{
    val isCoincidentTrigger = parse_element (element ("""MeterReading.isCoincidentTrigger"""))
    val CustomerAgreement = parse_attribute (attribute ("""MeterReading.CustomerAgreement"""))
    val Meter = parse_attribute (attribute ("""MeterReading.Meter"""))
    val UsagePoint = parse_attribute (attribute ("""MeterReading.UsagePoint"""))
    val valuesInterval = parse_attribute (attribute ("""MeterReading.valuesInterval"""))
    def parse (context: Context): MeterReading =
    {
        return (
            MeterReading
            (
                IdentifiedObject.parse (context),
                toBoolean (isCoincidentTrigger (context), context),
                CustomerAgreement (context),
                Meter (context),
                UsagePoint (context),
                valuesInterval (context)
            )
        )
    }
}

case class MeterServiceWork
(
    override val sup: Work,
    val Meter: String,
    val OldMeter: String,
    val UsagePoint: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Work: Work = sup.asInstanceOf[Work]
    override def copy (): Row = { return (clone ().asInstanceOf[MeterServiceWork]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MeterServiceWork
extends
    Parseable[MeterServiceWork]
{
    val Meter = parse_attribute (attribute ("""MeterServiceWork.Meter"""))
    val OldMeter = parse_attribute (attribute ("""MeterServiceWork.OldMeter"""))
    val UsagePoint = parse_attribute (attribute ("""MeterServiceWork.UsagePoint"""))
    def parse (context: Context): MeterServiceWork =
    {
        return (
            MeterServiceWork
            (
                Work.parse (context),
                Meter (context),
                OldMeter (context),
                UsagePoint (context)
            )
        )
    }
}

case class MetrologyRequirement
(
    override val sup: IdentifiedObject,
    val reason: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MetrologyRequirement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MetrologyRequirement
extends
    Parseable[MetrologyRequirement]
{
    val reason = parse_attribute (attribute ("""MetrologyRequirement.reason"""))
    def parse (context: Context): MetrologyRequirement =
    {
        return (
            MetrologyRequirement
            (
                IdentifiedObject.parse (context),
                reason (context)
            )
        )
    }
}

case class PanDemandResponse
(
    override val sup: EndDeviceAction,
    val avgLoadAdjustment: Double,
    val cancelControlMode: String,
    val cancelDateTime: String,
    val cancelNow: Boolean,
    val coolingOffset: Double,
    val coolingSetpoint: Double,
    val criticalityLevel: String,
    val dutyCycle: Double,
    val enrollmentGroup: String,
    val heatingOffset: Double,
    val heatingSetpoint: Double,
    val appliance: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, false, 0.0, 0.0, null, 0.0, null, 0.0, 0.0, null) }
    def EndDeviceAction: EndDeviceAction = sup.asInstanceOf[EndDeviceAction]
    override def copy (): Row = { return (clone ().asInstanceOf[PanDemandResponse]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PanDemandResponse
extends
    Parseable[PanDemandResponse]
{
    val avgLoadAdjustment = parse_element (element ("""PanDemandResponse.avgLoadAdjustment"""))
    val cancelControlMode = parse_element (element ("""PanDemandResponse.cancelControlMode"""))
    val cancelDateTime = parse_element (element ("""PanDemandResponse.cancelDateTime"""))
    val cancelNow = parse_element (element ("""PanDemandResponse.cancelNow"""))
    val coolingOffset = parse_element (element ("""PanDemandResponse.coolingOffset"""))
    val coolingSetpoint = parse_element (element ("""PanDemandResponse.coolingSetpoint"""))
    val criticalityLevel = parse_element (element ("""PanDemandResponse.criticalityLevel"""))
    val dutyCycle = parse_element (element ("""PanDemandResponse.dutyCycle"""))
    val enrollmentGroup = parse_element (element ("""PanDemandResponse.enrollmentGroup"""))
    val heatingOffset = parse_element (element ("""PanDemandResponse.heatingOffset"""))
    val heatingSetpoint = parse_element (element ("""PanDemandResponse.heatingSetpoint"""))
    val appliance = parse_attribute (attribute ("""PanDemandResponse.appliance"""))
    def parse (context: Context): PanDemandResponse =
    {
        return (
            PanDemandResponse
            (
                EndDeviceAction.parse (context),
                toDouble (avgLoadAdjustment (context), context),
                cancelControlMode (context),
                cancelDateTime (context),
                toBoolean (cancelNow (context), context),
                toDouble (coolingOffset (context), context),
                toDouble (coolingSetpoint (context), context),
                criticalityLevel (context),
                toDouble (dutyCycle (context), context),
                enrollmentGroup (context),
                toDouble (heatingOffset (context), context),
                toDouble (heatingSetpoint (context), context),
                appliance (context)
            )
        )
    }
}

case class PanDisplay
(
    override val sup: EndDeviceAction,
    val confirmationRequired: Boolean,
    val priority: String,
    val textMessage: String,
    val transmissionMode: String
)
extends
    Element
{
    def this () = { this (null, false, null, null, null) }
    def EndDeviceAction: EndDeviceAction = sup.asInstanceOf[EndDeviceAction]
    override def copy (): Row = { return (clone ().asInstanceOf[PanDisplay]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PanDisplay
extends
    Parseable[PanDisplay]
{
    val confirmationRequired = parse_element (element ("""PanDisplay.confirmationRequired"""))
    val priority = parse_element (element ("""PanDisplay.priority"""))
    val textMessage = parse_element (element ("""PanDisplay.textMessage"""))
    val transmissionMode = parse_attribute (attribute ("""PanDisplay.transmissionMode"""))
    def parse (context: Context): PanDisplay =
    {
        return (
            PanDisplay
            (
                EndDeviceAction.parse (context),
                toBoolean (confirmationRequired (context), context),
                priority (context),
                textMessage (context),
                transmissionMode (context)
            )
        )
    }
}

case class PanPricing
(
    override val sup: EndDeviceAction,
    val providerID: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def EndDeviceAction: EndDeviceAction = sup.asInstanceOf[EndDeviceAction]
    override def copy (): Row = { return (clone ().asInstanceOf[PanPricing]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PanPricing
extends
    Parseable[PanPricing]
{
    val providerID = parse_element (element ("""PanPricing.providerID"""))
    def parse (context: Context): PanPricing =
    {
        return (
            PanPricing
            (
                EndDeviceAction.parse (context),
                providerID (context)
            )
        )
    }
}

case class PanPricingDetail
(
    override val sup: BasicElement,
    val alternateCostDelivered: Double,
    val alternateCostUnit: String,
    val currentTimeDate: String,
    val generationPrice: String,
    val generationPriceRatio: Double,
    val price: String,
    val priceRatio: Double,
    val priceTier: Int,
    val priceTierCount: Int,
    val priceTierLabel: String,
    val rateLabel: String,
    val registerTier: String,
    val unitOfMeasure: String,
    val PanPricing: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, 0.0, null, 0.0, 0, 0, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PanPricingDetail]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PanPricingDetail
extends
    Parseable[PanPricingDetail]
{
    val alternateCostDelivered = parse_element (element ("""PanPricingDetail.alternateCostDelivered"""))
    val alternateCostUnit = parse_element (element ("""PanPricingDetail.alternateCostUnit"""))
    val currentTimeDate = parse_element (element ("""PanPricingDetail.currentTimeDate"""))
    val generationPrice = parse_element (element ("""PanPricingDetail.generationPrice"""))
    val generationPriceRatio = parse_element (element ("""PanPricingDetail.generationPriceRatio"""))
    val price = parse_element (element ("""PanPricingDetail.price"""))
    val priceRatio = parse_element (element ("""PanPricingDetail.priceRatio"""))
    val priceTier = parse_element (element ("""PanPricingDetail.priceTier"""))
    val priceTierCount = parse_element (element ("""PanPricingDetail.priceTierCount"""))
    val priceTierLabel = parse_element (element ("""PanPricingDetail.priceTierLabel"""))
    val rateLabel = parse_element (element ("""PanPricingDetail.rateLabel"""))
    val registerTier = parse_element (element ("""PanPricingDetail.registerTier"""))
    val unitOfMeasure = parse_element (element ("""PanPricingDetail.unitOfMeasure"""))
    val PanPricing = parse_attribute (attribute ("""PanPricingDetail.PanPricing"""))
    def parse (context: Context): PanPricingDetail =
    {
        return (
            PanPricingDetail
            (
                BasicElement.parse (context),
                toDouble (alternateCostDelivered (context), context),
                alternateCostUnit (context),
                currentTimeDate (context),
                generationPrice (context),
                toDouble (generationPriceRatio (context), context),
                price (context),
                toDouble (priceRatio (context), context),
                toInteger (priceTier (context), context),
                toInteger (priceTierCount (context), context),
                priceTierLabel (context),
                rateLabel (context),
                registerTier (context),
                unitOfMeasure (context),
                PanPricing (context)
            )
        )
    }
}

case class PendingCalculation
(
    override val sup: BasicElement,
    val multiplyBeforeAdd: Boolean,
    val offset: Int,
    val scalarDenominator: Int,
    val scalarFloat: Double,
    val scalarNumerator: Int,
    val ReadingType: String
)
extends
    Element
{
    def this () = { this (null, false, 0, 0, 0.0, 0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PendingCalculation]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PendingCalculation
extends
    Parseable[PendingCalculation]
{
    val multiplyBeforeAdd = parse_element (element ("""PendingCalculation.multiplyBeforeAdd"""))
    val offset = parse_element (element ("""PendingCalculation.offset"""))
    val scalarDenominator = parse_element (element ("""PendingCalculation.scalarDenominator"""))
    val scalarFloat = parse_element (element ("""PendingCalculation.scalarFloat"""))
    val scalarNumerator = parse_element (element ("""PendingCalculation.scalarNumerator"""))
    val ReadingType = parse_attribute (attribute ("""PendingCalculation.ReadingType"""))
    def parse (context: Context): PendingCalculation =
    {
        return (
            PendingCalculation
            (
                BasicElement.parse (context),
                toBoolean (multiplyBeforeAdd (context), context),
                toInteger (offset (context), context),
                toInteger (scalarDenominator (context), context),
                toDouble (scalarFloat (context), context),
                toInteger (scalarNumerator (context), context),
                ReadingType (context)
            )
        )
    }
}

case class RationalNumber
(
    override val sup: BasicElement,
    val denominator: Int,
    val numerator: Int
)
extends
    Element
{
    def this () = { this (null, 0, 0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RationalNumber]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RationalNumber
extends
    Parseable[RationalNumber]
{
    val denominator = parse_element (element ("""RationalNumber.denominator"""))
    val numerator = parse_element (element ("""RationalNumber.numerator"""))
    def parse (context: Context): RationalNumber =
    {
        return (
            RationalNumber
            (
                BasicElement.parse (context),
                toInteger (denominator (context), context),
                toInteger (numerator (context), context)
            )
        )
    }
}

case class Reading
(
    override val sup: BaseReading,
    val reason: String,
    val ReadingType: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def BaseReading: BaseReading = sup.asInstanceOf[BaseReading]
    override def copy (): Row = { return (clone ().asInstanceOf[Reading]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Reading
extends
    Parseable[Reading]
{
    val reason = parse_attribute (attribute ("""Reading.reason"""))
    val ReadingType = parse_attribute (attribute ("""Reading.ReadingType"""))
    def parse (context: Context): Reading =
    {
        return (
            Reading
            (
                BaseReading.parse (context),
                reason (context),
                ReadingType (context)
            )
        )
    }
}

case class ReadingInterharmonic
(
    override val sup: BasicElement,
    val denominator: Int,
    val numerator: Int
)
extends
    Element
{
    def this () = { this (null, 0, 0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ReadingInterharmonic]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ReadingInterharmonic
extends
    Parseable[ReadingInterharmonic]
{
    val denominator = parse_element (element ("""ReadingInterharmonic.denominator"""))
    val numerator = parse_element (element ("""ReadingInterharmonic.numerator"""))
    def parse (context: Context): ReadingInterharmonic =
    {
        return (
            ReadingInterharmonic
            (
                BasicElement.parse (context),
                toInteger (denominator (context), context),
                toInteger (numerator (context), context)
            )
        )
    }
}

case class ReadingQuality
(
    override val sup: BasicElement,
    val comment: String,
    val source: String,
    val timeStamp: String,  // dateTime
    val Reading: String,
    val ReadingQualityType: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ReadingQuality]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ReadingQuality
extends
    Parseable[ReadingQuality]
{
    val comment = parse_element (element ("""ReadingQuality.comment"""))
    val source = parse_element (element ("""ReadingQuality.source"""))
    val timeStamp = parse_element (element ("""ReadingQuality.timeStamp"""))
    val Reading = parse_attribute (attribute ("""ReadingQuality.Reading"""))
    val ReadingQualityType = parse_attribute (attribute ("""ReadingQuality.ReadingQualityType"""))
    def parse (context: Context): ReadingQuality =
    {
        return (
            ReadingQuality
            (
                BasicElement.parse (context),
                comment (context),
                source (context),
                timeStamp (context),
                Reading (context),
                ReadingQualityType (context)
            )
        )
    }
}

case class ReadingQualityType
(
    override val sup: IdentifiedObject,
    val category: String,
    val subCategory: String,
    val systemId: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ReadingQualityType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ReadingQualityType
extends
    Parseable[ReadingQualityType]
{
    val category = parse_element (element ("""ReadingQualityType.category"""))
    val subCategory = parse_element (element ("""ReadingQualityType.subCategory"""))
    val systemId = parse_element (element ("""ReadingQualityType.systemId"""))
    def parse (context: Context): ReadingQualityType =
    {
        return (
            ReadingQualityType
            (
                IdentifiedObject.parse (context),
                category (context),
                subCategory (context),
                systemId (context)
            )
        )
    }
}

case class ReadingType
(
    override val sup: IdentifiedObject,
    val accumulation: String,
    val aggregate: String,
    val commodity: String,
    val consumptionTier: Int,
    val cpp: Int,
    val currency: String,
    val flowDirection: String,
    val macroPeriod: String,
    val measurementKind: String,
    val measuringPeriod: String,
    val multiplier: String,
    val phases: String,
    val tou: Int,
    val unit: String,
    val Channel: String,
    val PendingCalculation: String,
    val argument: String,  // RationalNumber
    val interharmonic: String  // ReadingInterharmonic
    
)
extends
    Element
{
    def this () = { this (null, null, null, null, 0, 0, null, null, null, null, null, null, null, 0, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ReadingType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ReadingType
extends
    Parseable[ReadingType]
{
    val accumulation = parse_element (element ("""ReadingType.accumulation"""))
    val aggregate = parse_element (element ("""ReadingType.aggregate"""))
    val commodity = parse_element (element ("""ReadingType.commodity"""))
    val consumptionTier = parse_element (element ("""ReadingType.consumptionTier"""))
    val cpp = parse_element (element ("""ReadingType.cpp"""))
    val currency = parse_element (element ("""ReadingType.currency"""))
    val flowDirection = parse_element (element ("""ReadingType.flowDirection"""))
    val macroPeriod = parse_element (element ("""ReadingType.macroPeriod"""))
    val measurementKind = parse_element (element ("""ReadingType.measurementKind"""))
    val measuringPeriod = parse_element (element ("""ReadingType.measuringPeriod"""))
    val multiplier = parse_element (element ("""ReadingType.multiplier"""))
    val phases = parse_element (element ("""ReadingType.phases"""))
    val tou = parse_element (element ("""ReadingType.tou"""))
    val unit = parse_element (element ("""ReadingType.unit"""))
    val Channel = parse_attribute (attribute ("""ReadingType.Channel"""))
    val PendingCalculation = parse_attribute (attribute ("""ReadingType.PendingCalculation"""))
    val argument = parse_attribute (attribute ("""ReadingType.argument"""))
    val interharmonic = parse_attribute (attribute ("""ReadingType.interharmonic"""))
    def parse (context: Context): ReadingType =
    {
        return (
            ReadingType
            (
                IdentifiedObject.parse (context),
                accumulation (context),
                aggregate (context),
                commodity (context),
                toInteger (consumptionTier (context), context),
                toInteger (cpp (context), context),
                currency (context),
                flowDirection (context),
                macroPeriod (context),
                measurementKind (context),
                measuringPeriod (context),
                multiplier (context),
                phases (context),
                toInteger (tou (context), context),
                unit (context),
                Channel (context),
                PendingCalculation (context),
                argument (context),
                interharmonic (context)
            )
        )
    }
}

case class Register
(
    override val sup: IdentifiedObject,
    val isVirtual: Boolean,
    val leftDigitCount: Int,
    val rightDigitCount: Int,
    val touTierName: String,
    val EndDeviceFunction: String,
    val touTier: String  // TimeInterval
)
extends
    Element
{
    def this () = { this (null, false, 0, 0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Register]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Register
extends
    Parseable[Register]
{
    val isVirtual = parse_element (element ("""Register.isVirtual"""))
    val leftDigitCount = parse_element (element ("""Register.leftDigitCount"""))
    val rightDigitCount = parse_element (element ("""Register.rightDigitCount"""))
    val touTierName = parse_element (element ("""Register.touTierName"""))
    val EndDeviceFunction = parse_attribute (attribute ("""Register.EndDeviceFunction"""))
    val touTier = parse_attribute (attribute ("""Register.touTier"""))
    def parse (context: Context): Register =
    {
        return (
            Register
            (
                IdentifiedObject.parse (context),
                toBoolean (isVirtual (context), context),
                toInteger (leftDigitCount (context), context),
                toInteger (rightDigitCount (context), context),
                touTierName (context),
                EndDeviceFunction (context),
                touTier (context)
            )
        )
    }
}

case class ServiceMultiplier
(
    override val sup: IdentifiedObject,
    val kind: String,
    val value: Double,
    val UsagePoint: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ServiceMultiplier]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ServiceMultiplier
extends
    Parseable[ServiceMultiplier]
{
    val kind = parse_attribute (attribute ("""ServiceMultiplier.kind"""))
    val value = parse_element (element ("""ServiceMultiplier.value"""))
    val UsagePoint = parse_attribute (attribute ("""ServiceMultiplier.UsagePoint"""))
    def parse (context: Context): ServiceMultiplier =
    {
        return (
            ServiceMultiplier
            (
                IdentifiedObject.parse (context),
                kind (context),
                toDouble (value (context), context),
                UsagePoint (context)
            )
        )
    }
}

case class SimpleEndDeviceFunction
(
    override val sup: EndDeviceFunction,
    val kind: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def EndDeviceFunction: EndDeviceFunction = sup.asInstanceOf[EndDeviceFunction]
    override def copy (): Row = { return (clone ().asInstanceOf[SimpleEndDeviceFunction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SimpleEndDeviceFunction
extends
    Parseable[SimpleEndDeviceFunction]
{
    val kind = parse_attribute (attribute ("""SimpleEndDeviceFunction.kind"""))
    def parse (context: Context): SimpleEndDeviceFunction =
    {
        return (
            SimpleEndDeviceFunction
            (
                EndDeviceFunction.parse (context),
                kind (context)
            )
        )
    }
}

case class UsagePoint
(
    override val sup: IdentifiedObject,
    // val amiBillingReady: String, Implementation restriction: case  classes cannot have more than 22 parameters.
    val checkBilling: Boolean,
    val connectionState: String,
    val estimatedLoad: Double,
    val grounded: Boolean,
    val isSdp: Boolean,
    val isVirtual: Boolean,
    val minimalUsageExpected: Boolean,
    val nominalServiceVoltage: Double,
    val outageRegion: String,
    val phaseCode: String,
    val ratedCurrent: Double,
    val ratedPower: Double,
    val readCycle: String,
    val readRoute: String,
    val serviceDeliveryRemark: String,
    val servicePriority: String,
    val CustomerAgreement: String,
    val ServiceCategory: String,
    val ServiceLocation: String,
    val ServiceSupplier: String,
    val UsagePointLocation: String
)
extends
    Element
{
    def this () = { this (null, false, null, 0.0, false, false, false, false, 0.0, null, null, 0.0, 0.0, null, null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[UsagePoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UsagePoint
extends
    Parseable[UsagePoint]
{
    //val amiBillingReady = parse_element (element ("""UsagePoint.amiBillingReady"""))
    val checkBilling = parse_element (element ("""UsagePoint.checkBilling"""))
    val connectionState = parse_element (element ("""UsagePoint.connectionState"""))
    val estimatedLoad = parse_element (element ("""UsagePoint.estimatedLoad"""))
    val grounded = parse_element (element ("""UsagePoint.grounded"""))
    val isSdp = parse_element (element ("""UsagePoint.isSdp"""))
    val isVirtual = parse_element (element ("""UsagePoint.isSdp"""))
    val minimalUsageExpected = parse_element (element ("""UsagePoint.minimalUsageExpected"""))
    val nominalServiceVoltage = parse_element (element ("""UsagePoint.nominalServiceVoltage"""))
    val outageRegion = parse_element (element ("""UsagePoint.outageRegion"""))
    val phaseCode = parse_element (element ("""UsagePoint.phaseCode"""))
    val ratedCurrent = parse_element (element ("""UsagePoint.ratedCurrent"""))
    val ratedPower = parse_element (element ("""UsagePoint.ratedPower"""))
    val readCycle = parse_element (element ("""UsagePoint.readCycle"""))
    val readRoute = parse_element (element ("""UsagePoint.readRoute"""))
    val serviceDeliveryRemark = parse_element (element ("""UsagePoint.serviceDeliveryRemark"""))
    val servicePriority = parse_element (element ("""UsagePoint.servicePriority"""))
    val CustomerAgreement = parse_attribute (attribute ("""UsagePoint.CustomerAgreement"""))
    val ServiceCategory = parse_attribute (attribute ("""UsagePoint.ServiceCategory"""))
    val ServiceLocation = parse_attribute (attribute ("""UsagePoint.ServiceLocation"""))
    val ServiceSupplier = parse_attribute (attribute ("""UsagePoint.ServiceSupplier"""))
    val UsagePointLocation = parse_attribute (attribute ("""UsagePoint.UsagePointLocation"""))
    def parse (context: Context): UsagePoint =
    {
        return (
            UsagePoint
            (
                IdentifiedObject.parse (context),
                //amiBillingReady (context),
                toBoolean (checkBilling (context), context),
                connectionState (context),
                toDouble (estimatedLoad (context), context),
                toBoolean (grounded (context), context),
                toBoolean (isSdp (context), context),
                toBoolean (isVirtual (context), context),
                toBoolean (minimalUsageExpected (context), context),
                toDouble (nominalServiceVoltage (context), context),
                outageRegion (context),
                phaseCode (context),
                toDouble (ratedCurrent (context), context),
                toDouble (ratedPower (context), context),
                readCycle (context),
                readRoute (context),
                serviceDeliveryRemark (context),
                servicePriority (context),
                CustomerAgreement (context),
                ServiceCategory (context),
                ServiceLocation (context),
                ServiceSupplier (context),
                UsagePointLocation (context)
            )
        )
    }
}

case class UsagePointGroup
(
    override val sup: IdentifiedObject,
    val typ: String  // type
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[UsagePointGroup]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UsagePointGroup
extends
    Parseable[UsagePointGroup]
{
    val typ = parse_element (element ("""UsagePointGroup.typ"""))
    def parse (context: Context): UsagePointGroup =
    {
        return (
            UsagePointGroup
            (
                IdentifiedObject.parse (context),
                typ (context)
            )
        )
    }
}

case class UsagePointLocation
(
    override val sup: Location,
    val accessMethod: String,
    val remark: String,
    val siteAccessProblem: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Location: Location = sup.asInstanceOf[Location]
    override def copy (): Row = { return (clone ().asInstanceOf[UsagePointLocation]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UsagePointLocation
extends
    Parseable[UsagePointLocation]
{
    val accessMethod = parse_element (element ("""UsagePointLocation.accessMethod"""))
    val remark = parse_element (element ("""UsagePointLocation.remark"""))
    val siteAccessProblem = parse_element (element ("""UsagePointLocation.siteAccessProblem"""))
    def parse (context: Context): UsagePointLocation =
    {
        return (
            UsagePointLocation
            (
                Location.parse (context),
                accessMethod (context),
                remark (context),
                siteAccessProblem (context)
            )
        )
    }
}

object _Metering
{
    def register: Unit =
    {
        BaseReading.register
        Channel.register
        ComFunction.register
        ComModule.register
        ControlledAppliance.register
        DemandResponseProgram.register
        EndDevice.register
        EndDeviceAction.register
        EndDeviceCapability.register
        EndDeviceControl.register
        EndDeviceControlType.register
        EndDeviceEvent.register
        EndDeviceEventDetail.register
        EndDeviceEventType.register
        EndDeviceFunction.register
        EndDeviceGroup.register
        EndDeviceInfo.register
        EndDeviceTiming.register
        IntervalBlock.register
        IntervalReading.register
        Meter.register
        MeterMultiplier.register
        MeterReading.register
        MeterServiceWork.register
        MetrologyRequirement.register
        PanDemandResponse.register
        PanDisplay.register
        PanPricing.register
        PanPricingDetail.register
        PendingCalculation.register
        RationalNumber.register
        Reading.register
        ReadingInterharmonic.register
        ReadingQuality.register
        ReadingQualityType.register
        ReadingType.register
        Register.register
        ServiceMultiplier.register
        SimpleEndDeviceFunction.register        
        UsagePoint.register
        UsagePointGroup.register
        UsagePointLocation.register
    }
}
