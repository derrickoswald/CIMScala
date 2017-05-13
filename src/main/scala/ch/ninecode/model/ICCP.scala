package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


case class ICCPCommandPoint
(

    override val sup: ICCPControlPoint,

    val attr: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def ICCPControlPoint: ICCPControlPoint = sup.asInstanceOf[ICCPControlPoint]
    override def copy (): Row = { return (clone ().asInstanceOf[ICCPCommandPoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ICCPCommandPoint
extends
    Parseable[ICCPCommandPoint]
{
    val sup = ICCPControlPoint.parse _
    val attr = parse_attribute (attribute ("""ICCPCommandPoint."""))_
    def parse (context: Context): ICCPCommandPoint =
    {
        ICCPCommandPoint(
            sup (context),
            attr (context)
        )
    }
}

case class ICCPControlPoint
(

    override val sup: ICCPPoint,

    val attr: String,

    val deviceClass: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def ICCPPoint: ICCPPoint = sup.asInstanceOf[ICCPPoint]
    override def copy (): Row = { return (clone ().asInstanceOf[ICCPControlPoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ICCPControlPoint
extends
    Parseable[ICCPControlPoint]
{
    val sup = ICCPPoint.parse _
    val attr = parse_attribute (attribute ("""ICCPControlPoint."""))_
    val deviceClass = parse_attribute (attribute ("""ICCPControlPoint.deviceClass"""))_
    def parse (context: Context): ICCPControlPoint =
    {
        ICCPControlPoint(
            sup (context),
            attr (context),
            deviceClass (context)
        )
    }
}

case class ICCPControlPointDeviceClass
(

    override val sup: BasicElement,

    val NONSBO: String,

    val SBO: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ICCPControlPointDeviceClass]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ICCPControlPointDeviceClass
extends
    Parseable[ICCPControlPointDeviceClass]
{
    val sup = BasicElement.parse _
    val NONSBO = parse_attribute (attribute ("""ICCPControlPointDeviceClass.NONSBO"""))_
    val SBO = parse_attribute (attribute ("""ICCPControlPointDeviceClass.SBO"""))_
    def parse (context: Context): ICCPControlPointDeviceClass =
    {
        ICCPControlPointDeviceClass(
            sup (context),
            NONSBO (context),
            SBO (context)
        )
    }
}

case class ICCPIndicationPoint
(

    override val sup: ICCPPoint,

    val attr: String,

    val typ: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def ICCPPoint: ICCPPoint = sup.asInstanceOf[ICCPPoint]
    override def copy (): Row = { return (clone ().asInstanceOf[ICCPIndicationPoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ICCPIndicationPoint
extends
    Parseable[ICCPIndicationPoint]
{
    val sup = ICCPPoint.parse _
    val attr = parse_attribute (attribute ("""ICCPIndicationPoint."""))_
    val typ = parse_attribute (attribute ("""ICCPIndicationPoint.type"""))_
    def parse (context: Context): ICCPIndicationPoint =
    {
        ICCPIndicationPoint(
            sup (context),
            attr (context),
            typ (context)
        )
    }
}

case class ICCPIndicationPointType
(

    override val sup: BasicElement,

    val DISCRETE: String,

    val REAL: String,

    val STATE: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ICCPIndicationPointType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ICCPIndicationPointType
extends
    Parseable[ICCPIndicationPointType]
{
    val sup = BasicElement.parse _
    val DISCRETE = parse_attribute (attribute ("""ICCPIndicationPointType.DISCRETE"""))_
    val REAL = parse_attribute (attribute ("""ICCPIndicationPointType.REAL"""))_
    val STATE = parse_attribute (attribute ("""ICCPIndicationPointType.STATE"""))_
    def parse (context: Context): ICCPIndicationPointType =
    {
        ICCPIndicationPointType(
            sup (context),
            DISCRETE (context),
            REAL (context),
            STATE (context)
        )
    }
}

/**
 * This class represents the TASE.2 Information Message Object.
 * The IdentifiedObject.name attribute must be non-null.  The value of the attribute shall be used as the TASE.2 Information Reference, as specified by 60870-6-503.
 */
case class ICCPInformationMessage
(

    override val sup: IdentifiedObject,

    val attr: List[String],

    /**
     * The Local Reference attribute specifies a value agreed upon between sender and receiver of the Information Message.
     * It further identifies the Information Message.
     */
    val localReference: String,

    val scope: String
)
extends
    Element
{
    def this () = { this (null, List(), null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ICCPInformationMessage]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ICCPInformationMessage
extends
    Parseable[ICCPInformationMessage]
{
    val sup = IdentifiedObject.parse _
    val attr = parse_attributes (attribute ("""ICCPInformationMessage."""))_
    val localReference = parse_element (element ("""ICCPInformationMessage.localReference"""))_
    val scope = parse_attribute (attribute ("""ICCPInformationMessage.scope"""))_
    def parse (context: Context): ICCPInformationMessage =
    {
        ICCPInformationMessage(
            sup (context),
            attr (context),
            localReference (context),
            scope (context)
        )
    }
}

case class ICCPPScope
(

    override val sup: BasicElement,

    val ICC: String,

    val VCC: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ICCPPScope]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ICCPPScope
extends
    Parseable[ICCPPScope]
{
    val sup = BasicElement.parse _
    val ICC = parse_attribute (attribute ("""ICCPPScope.ICC"""))_
    val VCC = parse_attribute (attribute ("""ICCPPScope.VCC"""))_
    def parse (context: Context): ICCPPScope =
    {
        ICCPPScope(
            sup (context),
            ICC (context),
            VCC (context)
        )
    }
}

/**
 * The IdentifiedObject.name attribute must have a value.
 * The name attribute shall be used as the DataValue name used for the exchange.
 */
case class ICCPPoint
(

    override val sup: IdentifiedObject,

    val attr: String,

    val scope: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ICCPPoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ICCPPoint
extends
    Parseable[ICCPPoint]
{
    val sup = IdentifiedObject.parse _
    val attr = parse_attribute (attribute ("""ICCPPoint."""))_
    val scope = parse_attribute (attribute ("""ICCPPoint.scope"""))_
    def parse (context: Context): ICCPPoint =
    {
        ICCPPoint(
            sup (context),
            attr (context),
            scope (context)
        )
    }
}

case class ICCPSetPoint
(

    override val sup: ICCPControlPoint,

    val attr: String,

    val typ: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def ICCPControlPoint: ICCPControlPoint = sup.asInstanceOf[ICCPControlPoint]
    override def copy (): Row = { return (clone ().asInstanceOf[ICCPSetPoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ICCPSetPoint
extends
    Parseable[ICCPSetPoint]
{
    val sup = ICCPControlPoint.parse _
    val attr = parse_attribute (attribute ("""ICCPSetPoint."""))_
    val typ = parse_attribute (attribute ("""ICCPSetPoint.type"""))_
    def parse (context: Context): ICCPSetPoint =
    {
        ICCPSetPoint(
            sup (context),
            attr (context),
            typ (context)
        )
    }
}

case class ICCPSetPointType
(

    override val sup: BasicElement,

    val DISCRETE: String,

    val REAL: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ICCPSetPointType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ICCPSetPointType
extends
    Parseable[ICCPSetPointType]
{
    val sup = BasicElement.parse _
    val DISCRETE = parse_attribute (attribute ("""ICCPSetPointType.DISCRETE"""))_
    val REAL = parse_attribute (attribute ("""ICCPSetPointType.REAL"""))_
    def parse (context: Context): ICCPSetPointType =
    {
        ICCPSetPointType(
            sup (context),
            DISCRETE (context),
            REAL (context)
        )
    }
}

case class IPAccessPoint
(

    override val sup: BasicElement,

    val address: String,

    val addressType: String,

    val attr: String,

    val gateway: String,

    val subnet: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[IPAccessPoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IPAccessPoint
extends
    Parseable[IPAccessPoint]
{
    val sup = BasicElement.parse _
    val address = parse_element (element ("""IPAccessPoint.address"""))_
    val addressType = parse_attribute (attribute ("""IPAccessPoint.addressType"""))_
    val attr = parse_attribute (attribute ("""IPAccessPoint."""))_
    val gateway = parse_element (element ("""IPAccessPoint.gateway"""))_
    val subnet = parse_element (element ("""IPAccessPoint.subnet"""))_
    def parse (context: Context): IPAccessPoint =
    {
        IPAccessPoint(
            sup (context),
            address (context),
            addressType (context),
            attr (context),
            gateway (context),
            subnet (context)
        )
    }
}

case class IPAddressType
(

    override val sup: BasicElement,

    val multiplier: String,

    val unit: String,

    val value: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[IPAddressType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IPAddressType
extends
    Parseable[IPAddressType]
{
    val sup = BasicElement.parse _
    val multiplier = parse_attribute (attribute ("""IPAddressType.multiplier"""))_
    val unit = parse_attribute (attribute ("""IPAddressType.unit"""))_
    val value = parse_element (element ("""IPAddressType.value"""))_
    def parse (context: Context): IPAddressType =
    {
        IPAddressType(
            sup (context),
            multiplier (context),
            unit (context),
            value (context)
        )
    }
}

case class ISOAPAddressing
(

    override val sup: BasicElement,

    val multiplier: String,

    val unit: String,

    val value: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ISOAPAddressing]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ISOAPAddressing
extends
    Parseable[ISOAPAddressing]
{
    val sup = BasicElement.parse _
    val multiplier = parse_attribute (attribute ("""ISOAPAddressing.multiplier"""))_
    val unit = parse_attribute (attribute ("""ISOAPAddressing.unit"""))_
    val value = parse_element (element ("""ISOAPAddressing.value"""))_
    def parse (context: Context): ISOAPAddressing =
    {
        ISOAPAddressing(
            sup (context),
            multiplier (context),
            unit (context),
            value (context)
        )
    }
}

case class ISOUpperLayer
(

    override val sup: TCPAcessPoint,

    val ap: String,

    val osiPsel: String,

    val osiSsel: String,

    val osiTsel: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def TCPAcessPoint: TCPAcessPoint = sup.asInstanceOf[TCPAcessPoint]
    override def copy (): Row = { return (clone ().asInstanceOf[ISOUpperLayer]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ISOUpperLayer
extends
    Parseable[ISOUpperLayer]
{
    val sup = TCPAcessPoint.parse _
    val ap = parse_attribute (attribute ("""ISOUpperLayer.ap"""))_
    val osiPsel = parse_element (element ("""ISOUpperLayer.osiPsel"""))_
    val osiSsel = parse_element (element ("""ISOUpperLayer.osiSsel"""))_
    val osiTsel = parse_element (element ("""ISOUpperLayer.osiTsel"""))_
    def parse (context: Context): ISOUpperLayer =
    {
        ISOUpperLayer(
            sup (context),
            ap (context),
            osiPsel (context),
            osiSsel (context),
            osiTsel (context)
        )
    }
}

/**
 * This class describe the sending (providing) side in a bilateral ICCP data exchange.
 * Hence the ICCP bilateral (table) descriptions are created by exchanging ICCPProvider data between the parties.
 */
case class TASE2BilateralTable
(

    override val sup: IdentifiedObject,

    /**
     * Specifies the version of the Bilateral Table configuration that is being exchanged.
     */
    val bilateralTableID: String,

    /**
     * Used to indicate if the Provider is responsible for initiating the TASE.2 connection.
     * If the value is TRUE, the provider is responsible for establishing the association.  If the value is FALSE, the peer provider of the Bilateral Table will need to establish the association.
     */
    val calling: Boolean,

    /**
     * Specifies the ICC scope name that the remote can use to access the information in the Bilateral Table if the information is not VCC scoped.
     * This value may not be null.
     */
    val nameOfICC: String,

    /**
     * Specifies the version of the TASE.2 that is needed to access the Bilateral Table information via TASE.2
     */
    val tase2version: String
)
extends
    Element
{
    def this () = { this (null, null, false, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TASE2BilateralTable]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TASE2BilateralTable
extends
    Parseable[TASE2BilateralTable]
{
    val sup = IdentifiedObject.parse _
    val bilateralTableID = parse_element (element ("""TASE2BilateralTable.bilateralTableID"""))_
    val calling = parse_element (element ("""TASE2BilateralTable.calling"""))_
    val nameOfICC = parse_element (element ("""TASE2BilateralTable.nameOfICC"""))_
    val tase2version = parse_element (element ("""TASE2BilateralTable.tase2version"""))_
    def parse (context: Context): TASE2BilateralTable =
    {
        TASE2BilateralTable(
            sup (context),
            bilateralTableID (context),
            toBoolean (calling (context), context),
            nameOfICC (context),
            tase2version (context)
        )
    }
}

case class TCPAcessPoint
(

    override val sup: IPAccessPoint,

    val keepAliveTime: Int,

    val port: Int
)
extends
    Element
{
    def this () = { this (null, 0, 0) }
    def IPAccessPoint: IPAccessPoint = sup.asInstanceOf[IPAccessPoint]
    override def copy (): Row = { return (clone ().asInstanceOf[TCPAcessPoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TCPAcessPoint
extends
    Parseable[TCPAcessPoint]
{
    val sup = IPAccessPoint.parse _
    val keepAliveTime = parse_element (element ("""TCPAcessPoint.keepAliveTime"""))_
    val port = parse_element (element ("""TCPAcessPoint.port"""))_
    def parse (context: Context): TCPAcessPoint =
    {
        TCPAcessPoint(
            sup (context),
            toInteger (keepAliveTime (context), context),
            toInteger (port (context), context)
        )
    }
}

object _ICCP
{
    def register: Unit =
    {
        ICCPCommandPoint.register
        ICCPControlPoint.register
        ICCPControlPointDeviceClass.register
        ICCPIndicationPoint.register
        ICCPIndicationPointType.register
        ICCPInformationMessage.register
        ICCPPScope.register
        ICCPPoint.register
        ICCPSetPoint.register
        ICCPSetPointType.register
        IPAccessPoint.register
        IPAddressType.register
        ISOAPAddressing.register
        ISOUpperLayer.register
        TASE2BilateralTable.register
        TCPAcessPoint.register
    }
}