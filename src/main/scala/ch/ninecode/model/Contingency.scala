package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Contingencies to be studied.
 */

/**
 * An event threatening system reliability, consisting of one or more contingency elements.
 */
case class Contingency
(

    override val sup: IdentifiedObject,

    /**
     * Set true if must study this contingency.
     */
    val mustStudy: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Contingency]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Contingency
extends
    Parseable[Contingency]
{
    val sup = IdentifiedObject.parse _
    val mustStudy = parse_element (element ("""Contingency.mustStudy"""))_
    def parse (context: Context): Contingency =
    {
        Contingency(
            sup (context),
            toBoolean (mustStudy (context), context)
        )
    }
}

/**
 * An element of a system event to be studied by contingency analysis, representing a change in status of a single piece of equipment.
 */
case class ContingencyElement
(

    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ContingencyElement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ContingencyElement
extends
    Parseable[ContingencyElement]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): ContingencyElement =
    {
        ContingencyElement(
            sup (context)
        )
    }
}

/**
 * A equipment to which the in service status is to change such as a power transformer or AC line segment.
 */
case class ContingencyEquipment
(

    override val sup: ContingencyElement,

    /**
     * The status for the associated equipment when in the contingency state.
     * This status is independent of the case to which the contingency is originally applied, but defines the equipment status when the contingency is applied.
     */
    val contingentStatus: String,

    /**
     * The single piece of equipment to which to apply the contingency.
     */
    val Equipment: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def ContingencyElement: ContingencyElement = sup.asInstanceOf[ContingencyElement]
    override def copy (): Row = { return (clone ().asInstanceOf[ContingencyEquipment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ContingencyEquipment
extends
    Parseable[ContingencyEquipment]
{
    val sup = ContingencyElement.parse _
    val contingentStatus = parse_attribute (attribute ("""ContingencyEquipment.contingentStatus"""))_
    val Equipment = parse_attribute (attribute ("""ContingencyEquipment.Equipment"""))_
    def parse (context: Context): ContingencyEquipment =
    {
        ContingencyEquipment(
            sup (context),
            contingentStatus (context),
            Equipment (context)
        )
    }
}

/**
 * Indicates the state which the contingency equipment is to be in when the contingency is applied.
 */
case class ContingencyEquipmentStatusKind
(

    override val sup: BasicElement,

    /**
     * The equipment is in service.
     */
    val inService: String,

    /**
     * The equipment is to be taken out of service.
     */
    val outOfService: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ContingencyEquipmentStatusKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ContingencyEquipmentStatusKind
extends
    Parseable[ContingencyEquipmentStatusKind]
{
    val sup = BasicElement.parse _
    val inService = parse_attribute (attribute ("""ContingencyEquipmentStatusKind.inService"""))_
    val outOfService = parse_attribute (attribute ("""ContingencyEquipmentStatusKind.outOfService"""))_
    def parse (context: Context): ContingencyEquipmentStatusKind =
    {
        ContingencyEquipmentStatusKind(
            sup (context),
            inService (context),
            outOfService (context)
        )
    }
}

object _Contingency
{
    def register: Unit =
    {
        Contingency.register
        ContingencyElement.register
        ContingencyEquipment.register
        ContingencyEquipmentStatusKind.register
    }
}