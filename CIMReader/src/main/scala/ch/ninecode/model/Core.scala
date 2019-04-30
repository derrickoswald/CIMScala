package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * An electrical connection point (AC or DC) to a piece of conducting equipment.
 *
 * Terminals are connected at physical connection points called connectivity nodes.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param connected The connected status is related to a bus-branch model and the topological node to terminal relation.
 *        True implies the terminal is connected to the related topological node and false implies it is not.
 * @param sequenceNumber The orientation of the terminal connections for a multiple terminal conducting equipment.
 *        The sequence numbering starts with 1 and additional terminals should follow in increasing order.   The first terminal is the "starting point" for a two terminal branch.
 * @param BusNameMarker [[ch.ninecode.model.BusNameMarker BusNameMarker]] The bus name marker used to name the bus (topological node).
 * @param Measurements [[ch.ninecode.model.Measurement Measurement]] Measurements associated with this terminal defining  where the measurement is placed in the network topology.
 *        It may be used, for instance, to capture the sensor position, such as a voltage transformer (PT) at a busbar or a current transformer (CT) at the bar between a breaker and an isolator.
 * @param OperationalLimitSet [[ch.ninecode.model.OperationalLimitSet OperationalLimitSet]] <em>undocumented</em>
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class ACDCTerminal
(
    override val sup: IdentifiedObject,
    connected: Boolean,
    sequenceNumber: Int,
    BusNameMarker: String,
    Measurements: List[String],
    OperationalLimitSet: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ACDCTerminal] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ACDCTerminal.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ACDCTerminal.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ACDCTerminal.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ACDCTerminal.fields (position), x))
        emitelem (0, connected)
        emitelem (1, sequenceNumber)
        emitattr (2, BusNameMarker)
        emitattrs (3, Measurements)
        emitattrs (4, OperationalLimitSet)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ACDCTerminal rdf:ID=\"%s\">\n%s\t</cim:ACDCTerminal>".format (id, export_fields)
    }
}

object ACDCTerminal
extends
    Parseable[ACDCTerminal]
{
    override val fields: Array[String] = Array[String] (
        "connected",
        "sequenceNumber",
        "BusNameMarker",
        "Measurements",
        "OperationalLimitSet"
    )
    override val relations: List[Relationship] = List (
        Relationship ("BusNameMarker", "BusNameMarker", "0..1", "1..*"),
        Relationship ("Measurements", "Measurement", "0..*", "0..1"),
        Relationship ("OperationalLimitSet", "OperationalLimitSet", "0..*", "0..1")
    )
    val connected: Fielder = parse_element (element (cls, fields(0)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields(1)))
    val BusNameMarker: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Measurements: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val OperationalLimitSet: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): ACDCTerminal =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ACDCTerminal (
            IdentifiedObject.parse (context),
            toBoolean (mask (connected (), 0)),
            toInteger (mask (sequenceNumber (), 1)),
            mask (BusNameMarker (), 2),
            masks (Measurements (), 3),
            masks (OperationalLimitSet (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class describe a base frequency for a power system network.
 *
 * In case of multiple power networks with different frequencies, e.g. 50 or 60 Hertz each network will have it's own base frequency class. Hence it is assumed that power system objects having different base frequencies appear in separate documents where each document has a single base frequency instance.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param frequency The base frequency.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class BaseFrequency
(
    override val sup: IdentifiedObject,
    frequency: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[BaseFrequency] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BaseFrequency.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BaseFrequency.fields (position), value)
        emitelem (0, frequency)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BaseFrequency rdf:ID=\"%s\">\n%s\t</cim:BaseFrequency>".format (id, export_fields)
    }
}

object BaseFrequency
extends
    Parseable[BaseFrequency]
{
    override val fields: Array[String] = Array[String] (
        "frequency"
    )
    val frequency: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): BaseFrequency =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BaseFrequency (
            IdentifiedObject.parse (context),
            toDouble (mask (frequency (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The BasePower class defines the base power used in the per unit calculations.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param basePower Value used as base power.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class BasePower
(
    override val sup: IdentifiedObject,
    basePower: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[BasePower] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BasePower.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BasePower.fields (position), value)
        emitelem (0, basePower)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BasePower rdf:ID=\"%s\">\n%s\t</cim:BasePower>".format (id, export_fields)
    }
}

object BasePower
extends
    Parseable[BasePower]
{
    override val fields: Array[String] = Array[String] (
        "basePower"
    )
    val basePower: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): BasePower =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BasePower (
            IdentifiedObject.parse (context),
            toDouble (mask (basePower (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Defines a system base voltage which is referenced.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param nominalVoltage The power system resource's base voltage.
 * @param ConductingEquipment [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] All conducting equipment with this base voltage.
 *        Use only when there is no voltage level container used and only one base voltage applies.  For example, not used for transformers.
 * @param TopologicalNode [[ch.ninecode.model.TopologicalNode TopologicalNode]] The topological nodes at the base voltage.
 * @param TransformerEnds [[ch.ninecode.model.TransformerEnd TransformerEnd]] Transformer ends at the base voltage.
 *        This is essential for PU calculation.
 * @param VoltageLevel [[ch.ninecode.model.VoltageLevel VoltageLevel]] The voltage levels having this base voltage.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class BaseVoltage
(
    override val sup: IdentifiedObject,
    nominalVoltage: Double,
    ConductingEquipment: List[String],
    TopologicalNode: List[String],
    TransformerEnds: List[String],
    VoltageLevel: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, List(), List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[BaseVoltage] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BaseVoltage.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BaseVoltage.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (BaseVoltage.fields (position), x))
        emitelem (0, nominalVoltage)
        emitattrs (1, ConductingEquipment)
        emitattrs (2, TopologicalNode)
        emitattrs (3, TransformerEnds)
        emitattrs (4, VoltageLevel)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BaseVoltage rdf:ID=\"%s\">\n%s\t</cim:BaseVoltage>".format (id, export_fields)
    }
}

object BaseVoltage
extends
    Parseable[BaseVoltage]
{
    override val fields: Array[String] = Array[String] (
        "nominalVoltage",
        "ConductingEquipment",
        "TopologicalNode",
        "TransformerEnds",
        "VoltageLevel"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ConductingEquipment", "ConductingEquipment", "0..*", "0..1"),
        Relationship ("TopologicalNode", "TopologicalNode", "0..*", "0..1"),
        Relationship ("TransformerEnds", "TransformerEnd", "0..*", "0..1"),
        Relationship ("VoltageLevel", "VoltageLevel", "0..*", "1")
    )
    val nominalVoltage: Fielder = parse_element (element (cls, fields(0)))
    val ConductingEquipment: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val TopologicalNode: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val TransformerEnds: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val VoltageLevel: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): BaseVoltage =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BaseVoltage (
            IdentifiedObject.parse (context),
            toDouble (mask (nominalVoltage (), 0)),
            masks (ConductingEquipment (), 1),
            masks (TopologicalNode (), 2),
            masks (TransformerEnds (), 3),
            masks (VoltageLevel (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Schedule of values at points in time.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param startTime The time for the first time point.
 * @param value1Multiplier Multiplier for value1.
 * @param value1Unit Value1 units of measure.
 * @param value2Multiplier Multiplier for value2.
 * @param value2Unit Value2 units of measure.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class BasicIntervalSchedule
(
    override val sup: IdentifiedObject,
    startTime: String,
    value1Multiplier: String,
    value1Unit: String,
    value2Multiplier: String,
    value2Unit: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[BasicIntervalSchedule] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BasicIntervalSchedule.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BasicIntervalSchedule.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BasicIntervalSchedule.fields (position), value)
        emitelem (0, startTime)
        emitattr (1, value1Multiplier)
        emitattr (2, value1Unit)
        emitattr (3, value2Multiplier)
        emitattr (4, value2Unit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BasicIntervalSchedule rdf:ID=\"%s\">\n%s\t</cim:BasicIntervalSchedule>".format (id, export_fields)
    }
}

object BasicIntervalSchedule
extends
    Parseable[BasicIntervalSchedule]
{
    override val fields: Array[String] = Array[String] (
        "startTime",
        "value1Multiplier",
        "value1Unit",
        "value2Multiplier",
        "value2Unit"
    )
    val startTime: Fielder = parse_element (element (cls, fields(0)))
    val value1Multiplier: Fielder = parse_attribute (attribute (cls, fields(1)))
    val value1Unit: Fielder = parse_attribute (attribute (cls, fields(2)))
    val value2Multiplier: Fielder = parse_attribute (attribute (cls, fields(3)))
    val value2Unit: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): BasicIntervalSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BasicIntervalSchedule (
            IdentifiedObject.parse (context),
            mask (startTime (), 0),
            mask (value1Multiplier (), 1),
            mask (value1Unit (), 2),
            mask (value2Multiplier (), 3),
            mask (value2Unit (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A collection of power system resources (within a given substation) including conducting equipment, protection relays, measurements, and telemetry.
 *
 * A bay typically represents a physical grouping related to modularization of equipment.
 *
 * @param sup [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Reference to the superclass object.
 * @param bayEnergyMeasFlag Indicates the presence/absence of energy measurements.
 * @param bayPowerMeasFlag Indicates the presence/absence of active/reactive power measurements.
 * @param breakerConfiguration Breaker configuration.
 * @param busBarConfiguration Bus bar configuration.
 * @param Substation [[ch.ninecode.model.Substation Substation]] Substation containing the bay.
 * @param VoltageLevel [[ch.ninecode.model.VoltageLevel VoltageLevel]] The voltage level containing this bay.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class Bay
(
    override val sup: EquipmentContainer,
    bayEnergyMeasFlag: Boolean,
    bayPowerMeasFlag: Boolean,
    breakerConfiguration: String,
    busBarConfiguration: String,
    Substation: String,
    VoltageLevel: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, false, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { clone ().asInstanceOf[Bay] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Bay.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Bay.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Bay.fields (position), value)
        emitelem (0, bayEnergyMeasFlag)
        emitelem (1, bayPowerMeasFlag)
        emitattr (2, breakerConfiguration)
        emitattr (3, busBarConfiguration)
        emitattr (4, Substation)
        emitattr (5, VoltageLevel)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Bay rdf:ID=\"%s\">\n%s\t</cim:Bay>".format (id, export_fields)
    }
}

object Bay
extends
    Parseable[Bay]
{
    override val fields: Array[String] = Array[String] (
        "bayEnergyMeasFlag",
        "bayPowerMeasFlag",
        "breakerConfiguration",
        "busBarConfiguration",
        "Substation",
        "VoltageLevel"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Substation", "Substation", "0..1", "0..*"),
        Relationship ("VoltageLevel", "VoltageLevel", "0..1", "0..*")
    )
    val bayEnergyMeasFlag: Fielder = parse_element (element (cls, fields(0)))
    val bayPowerMeasFlag: Fielder = parse_element (element (cls, fields(1)))
    val breakerConfiguration: Fielder = parse_attribute (attribute (cls, fields(2)))
    val busBarConfiguration: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Substation: Fielder = parse_attribute (attribute (cls, fields(4)))
    val VoltageLevel: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): Bay =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Bay (
            EquipmentContainer.parse (context),
            toBoolean (mask (bayEnergyMeasFlag (), 0)),
            toBoolean (mask (bayPowerMeasFlag (), 1)),
            mask (breakerConfiguration (), 2),
            mask (busBarConfiguration (), 3),
            mask (Substation (), 4),
            mask (VoltageLevel (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The parts of the AC power system that are designed to carry current or that are conductively connected through terminals.
 *
 * @param sup [[ch.ninecode.model.Equipment Equipment]] Reference to the superclass object.
 * @param BaseVoltage [[ch.ninecode.model.BaseVoltage BaseVoltage]] Base voltage of this conducting equipment.
 *        Use only when there is no voltage level container used and only one base voltage applies.  For example, not used for transformers.
 * @param GroundingAction [[ch.ninecode.model.GroundAction GroundAction]] Action involving grounding operation on this conducting equipment.
 * @param JumpingAction [[ch.ninecode.model.JumperAction JumperAction]] Jumper action involving jumping operation on this conducting equipment.
 * @param ProtectionEquipments [[ch.ninecode.model.ProtectionEquipment ProtectionEquipment]] Protection equipment  used to protect specific conducting equipment.
 * @param ProtectiveActionAdjustment [[ch.ninecode.model.ProtectiveActionAdjustment ProtectiveActionAdjustment]] <em>undocumented</em>
 * @param SvStatus [[ch.ninecode.model.SvStatus SvStatus]] The status state variable associated with this conducting equipment.
 * @param Terminals [[ch.ninecode.model.Terminal Terminal]] Conducting equipment have terminals that may be connected to other conducting equipment terminals via connectivity nodes or topological nodes.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class ConductingEquipment
(
    override val sup: Equipment,
    BaseVoltage: String,
    GroundingAction: String,
    JumpingAction: String,
    ProtectionEquipments: List[String],
    ProtectiveActionAdjustment: List[String],
    SvStatus: String,
    Terminals: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List(), List(), null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { clone ().asInstanceOf[ConductingEquipment] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ConductingEquipment.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ConductingEquipment.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ConductingEquipment.fields (position), x))
        emitattr (0, BaseVoltage)
        emitattr (1, GroundingAction)
        emitattr (2, JumpingAction)
        emitattrs (3, ProtectionEquipments)
        emitattrs (4, ProtectiveActionAdjustment)
        emitattr (5, SvStatus)
        emitattrs (6, Terminals)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ConductingEquipment rdf:ID=\"%s\">\n%s\t</cim:ConductingEquipment>".format (id, export_fields)
    }
}

object ConductingEquipment
extends
    Parseable[ConductingEquipment]
{
    override val fields: Array[String] = Array[String] (
        "BaseVoltage",
        "GroundingAction",
        "JumpingAction",
        "ProtectionEquipments",
        "ProtectiveActionAdjustment",
        "SvStatus",
        "Terminals"
    )
    override val relations: List[Relationship] = List (
        Relationship ("BaseVoltage", "BaseVoltage", "0..1", "0..*"),
        Relationship ("GroundingAction", "GroundAction", "0..1", "0..1"),
        Relationship ("JumpingAction", "JumperAction", "0..1", "0..*"),
        Relationship ("ProtectionEquipments", "ProtectionEquipment", "0..*", "0..*"),
        Relationship ("ProtectiveActionAdjustment", "ProtectiveActionAdjustment", "0..*", "1"),
        Relationship ("SvStatus", "SvStatus", "0..1", "1"),
        Relationship ("Terminals", "Terminal", "0..*", "1")
    )
    val BaseVoltage: Fielder = parse_attribute (attribute (cls, fields(0)))
    val GroundingAction: Fielder = parse_attribute (attribute (cls, fields(1)))
    val JumpingAction: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ProtectionEquipments: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val ProtectiveActionAdjustment: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val SvStatus: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Terminals: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: Context): ConductingEquipment =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ConductingEquipment (
            Equipment.parse (context),
            mask (BaseVoltage (), 0),
            mask (GroundingAction (), 1),
            mask (JumpingAction (), 2),
            masks (ProtectionEquipments (), 3),
            masks (ProtectiveActionAdjustment (), 4),
            mask (SvStatus (), 5),
            masks (Terminals (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Connectivity nodes are points where terminals of AC conducting equipment are connected together with zero impedance.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ConnectivityNodeContainer [[ch.ninecode.model.ConnectivityNodeContainer ConnectivityNodeContainer]] Container of this connectivity node.
 * @param Terminals [[ch.ninecode.model.Terminal Terminal]] Terminals interconnected with zero impedance at a this connectivity node.
 * @param TopologicalNode [[ch.ninecode.model.TopologicalNode TopologicalNode]] The topological node to which this connectivity node is assigned.
 *        May depend on the current state of switches in the network.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class ConnectivityNode
(
    override val sup: IdentifiedObject,
    ConnectivityNodeContainer: String,
    Terminals: List[String],
    TopologicalNode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ConnectivityNode] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ConnectivityNode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ConnectivityNode.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ConnectivityNode.fields (position), x))
        emitattr (0, ConnectivityNodeContainer)
        emitattrs (1, Terminals)
        emitattr (2, TopologicalNode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ConnectivityNode rdf:ID=\"%s\">\n%s\t</cim:ConnectivityNode>".format (id, export_fields)
    }
}

object ConnectivityNode
extends
    Parseable[ConnectivityNode]
{
    override val fields: Array[String] = Array[String] (
        "ConnectivityNodeContainer",
        "Terminals",
        "TopologicalNode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ConnectivityNodeContainer", "ConnectivityNodeContainer", "1", "0..*"),
        Relationship ("Terminals", "Terminal", "0..*", "0..1"),
        Relationship ("TopologicalNode", "TopologicalNode", "0..1", "0..*")
    )
    val ConnectivityNodeContainer: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Terminals: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val TopologicalNode: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): ConnectivityNode =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ConnectivityNode (
            IdentifiedObject.parse (context),
            mask (ConnectivityNodeContainer (), 0),
            masks (Terminals (), 1),
            mask (TopologicalNode (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A base class for all objects that may contain connectivity nodes or topological nodes.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param ConnectivityNodes [[ch.ninecode.model.ConnectivityNode ConnectivityNode]] Connectivity nodes which belong to this connectivity node container.
 * @param TopologicalNode [[ch.ninecode.model.TopologicalNode TopologicalNode]] The topological nodes which belong to this connectivity node container.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class ConnectivityNodeContainer
(
    override val sup: PowerSystemResource,
    ConnectivityNodes: List[String],
    TopologicalNode: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[ConnectivityNodeContainer] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ConnectivityNodeContainer.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ConnectivityNodeContainer.fields (position), x))
        emitattrs (0, ConnectivityNodes)
        emitattrs (1, TopologicalNode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ConnectivityNodeContainer rdf:ID=\"%s\">\n%s\t</cim:ConnectivityNodeContainer>".format (id, export_fields)
    }
}

object ConnectivityNodeContainer
extends
    Parseable[ConnectivityNodeContainer]
{
    override val fields: Array[String] = Array[String] (
        "ConnectivityNodes",
        "TopologicalNode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ConnectivityNodes", "ConnectivityNode", "0..*", "1"),
        Relationship ("TopologicalNode", "TopologicalNode", "0..*", "0..1")
    )
    val ConnectivityNodes: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val TopologicalNode: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): ConnectivityNodeContainer =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ConnectivityNodeContainer (
            PowerSystemResource.parse (context),
            masks (ConnectivityNodes (), 0),
            masks (TopologicalNode (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A multi-purpose curve or functional relationship between an independent variable (X-axis) and dependent (Y-axis) variables.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param curveStyle The style or shape of the curve.
 * @param xMultiplier Multiplier for X-axis.
 * @param xUnit The X-axis units of measure.
 * @param y1Multiplier Multiplier for Y1-axis.
 * @param y1Unit The Y1-axis units of measure.
 * @param y2Multiplier Multiplier for Y2-axis.
 * @param y2Unit The Y2-axis units of measure.
 * @param y3Multiplier Multiplier for Y3-axis.
 * @param y3Unit The Y3-axis units of measure.
 * @param CurveDatas [[ch.ninecode.model.CurveData CurveData]] The point data values that define this curve.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class Curve
(
    override val sup: IdentifiedObject,
    curveStyle: String,
    xMultiplier: String,
    xUnit: String,
    y1Multiplier: String,
    y1Unit: String,
    y2Multiplier: String,
    y2Unit: String,
    y3Multiplier: String,
    y3Unit: String,
    CurveDatas: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Curve] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Curve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Curve.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Curve.fields (position), x))
        emitattr (0, curveStyle)
        emitattr (1, xMultiplier)
        emitattr (2, xUnit)
        emitattr (3, y1Multiplier)
        emitattr (4, y1Unit)
        emitattr (5, y2Multiplier)
        emitattr (6, y2Unit)
        emitattr (7, y3Multiplier)
        emitattr (8, y3Unit)
        emitattrs (9, CurveDatas)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Curve rdf:ID=\"%s\">\n%s\t</cim:Curve>".format (id, export_fields)
    }
}

object Curve
extends
    Parseable[Curve]
{
    override val fields: Array[String] = Array[String] (
        "curveStyle",
        "xMultiplier",
        "xUnit",
        "y1Multiplier",
        "y1Unit",
        "y2Multiplier",
        "y2Unit",
        "y3Multiplier",
        "y3Unit",
        "CurveDatas"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CurveDatas", "CurveData", "0..*", "1")
    )
    val curveStyle: Fielder = parse_attribute (attribute (cls, fields(0)))
    val xMultiplier: Fielder = parse_attribute (attribute (cls, fields(1)))
    val xUnit: Fielder = parse_attribute (attribute (cls, fields(2)))
    val y1Multiplier: Fielder = parse_attribute (attribute (cls, fields(3)))
    val y1Unit: Fielder = parse_attribute (attribute (cls, fields(4)))
    val y2Multiplier: Fielder = parse_attribute (attribute (cls, fields(5)))
    val y2Unit: Fielder = parse_attribute (attribute (cls, fields(6)))
    val y3Multiplier: Fielder = parse_attribute (attribute (cls, fields(7)))
    val y3Unit: Fielder = parse_attribute (attribute (cls, fields(8)))
    val CurveDatas: FielderMultiple = parse_attributes (attribute (cls, fields(9)))

    def parse (context: Context): Curve =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Curve (
            IdentifiedObject.parse (context),
            mask (curveStyle (), 0),
            mask (xMultiplier (), 1),
            mask (xUnit (), 2),
            mask (y1Multiplier (), 3),
            mask (y1Unit (), 4),
            mask (y2Multiplier (), 5),
            mask (y2Unit (), 6),
            mask (y3Multiplier (), 7),
            mask (y3Unit (), 8),
            masks (CurveDatas (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Multi-purpose data points for defining a curve.
 *
 * The use of this generic class is discouraged if a more specific class  can be used to specify the x and y axis values along with their specific data types.
 *
 * @param sup Reference to the superclass object.
 * @param xvalue The data value of the X-axis variable,  depending on the X-axis units.
 * @param y1value The data value of the  first Y-axis variable, depending on the Y-axis units.
 * @param y2value The data value of the second Y-axis variable (if present), depending on the Y-axis units.
 * @param y3value The data value of the third Y-axis variable (if present), depending on the Y-axis units.
 * @param Curve [[ch.ninecode.model.Curve Curve]] The curve of  this curve data point.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class CurveData
(
    override val sup: BasicElement,
    xvalue: Double,
    y1value: Double,
    y2value: Double,
    y3value: Double,
    Curve: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[CurveData] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CurveData.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CurveData.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CurveData.fields (position), value)
        emitelem (0, xvalue)
        emitelem (1, y1value)
        emitelem (2, y2value)
        emitelem (3, y3value)
        emitattr (4, Curve)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CurveData rdf:ID=\"%s\">\n%s\t</cim:CurveData>".format (id, export_fields)
    }
}

object CurveData
extends
    Parseable[CurveData]
{
    override val fields: Array[String] = Array[String] (
        "xvalue",
        "y1value",
        "y2value",
        "y3value",
        "Curve"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Curve", "Curve", "1", "0..*")
    )
    val xvalue: Fielder = parse_element (element (cls, fields(0)))
    val y1value: Fielder = parse_element (element (cls, fields(1)))
    val y2value: Fielder = parse_element (element (cls, fields(2)))
    val y3value: Fielder = parse_element (element (cls, fields(3)))
    val Curve: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): CurveData =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CurveData (
            BasicElement.parse (context),
            toDouble (mask (xvalue (), 0)),
            toDouble (mask (y1value (), 1)),
            toDouble (mask (y2value (), 2)),
            toDouble (mask (y3value (), 3)),
            mask (Curve (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The parts of a power system that are physical devices, electronic or mechanical.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param aggregate The single instance of equipment represents multiple pieces of equipment that have been modeled together as an aggregate.
 *        Examples would be power transformers or synchronous machines operating in parallel modeled as a single aggregate power transformer or aggregate synchronous machine.  This is not to be used to indicate equipment that is part of a group of interdependent equipment produced by a network production program.
 * @param normallyInService If true, the equipment is normally in service.
 * @param ContingencyEquipment [[ch.ninecode.model.ContingencyEquipment ContingencyEquipment]] The contingency equipments in which this equipment participates.
 * @param EqiupmentLimitSeriesComponent [[ch.ninecode.model.EquipmentLimitSeriesComponent EquipmentLimitSeriesComponent]] Equipment limit series calculation component to which this equipment contributes.
 * @param EquipmentContainer [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Container of this equipment.
 * @param Faults [[ch.ninecode.model.Fault Fault]] All faults on this equipment.
 * @param LimitDependencyModel [[ch.ninecode.model.LimitDependency LimitDependency]] Limit dependencymodels organized under this equipment as a means for organizing the model in a tree view.
 * @param OperationalLimitSet [[ch.ninecode.model.OperationalLimitSet OperationalLimitSet]] The operational limit sets associated with this equipment.
 * @param OperationalRestrictions [[ch.ninecode.model.OperationalRestriction OperationalRestriction]] All operational restrictions for this equipment.
 * @param Outages [[ch.ninecode.model.Outage Outage]] All outages in which this equipment is involved.
 * @param PinEquipment [[ch.ninecode.model.PinEquipment PinEquipment]] <em>undocumented</em>
 * @param ProtectiveActionEquipment [[ch.ninecode.model.ProtectiveActionEquipment ProtectiveActionEquipment]] <em>undocumented</em>
 * @param UsagePoints [[ch.ninecode.model.UsagePoint UsagePoint]] All usage points connected to the electrical grid through this equipment.
 * @param WeatherStation [[ch.ninecode.model.WeatherStation WeatherStation]] <em>undocumented</em>
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class Equipment
(
    override val sup: PowerSystemResource,
    aggregate: Boolean,
    normallyInService: Boolean,
    ContingencyEquipment: List[String],
    EqiupmentLimitSeriesComponent: List[String],
    EquipmentContainer: String,
    Faults: List[String],
    LimitDependencyModel: List[String],
    OperationalLimitSet: List[String],
    OperationalRestrictions: List[String],
    Outages: List[String],
    PinEquipment: List[String],
    ProtectiveActionEquipment: List[String],
    UsagePoints: List[String],
    WeatherStation: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, false, List(), List(), null, List(), List(), List(), List(), List(), List(), List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[Equipment] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Equipment.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Equipment.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Equipment.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Equipment.fields (position), x))
        emitelem (0, aggregate)
        emitelem (1, normallyInService)
        emitattrs (2, ContingencyEquipment)
        emitattrs (3, EqiupmentLimitSeriesComponent)
        emitattr (4, EquipmentContainer)
        emitattrs (5, Faults)
        emitattrs (6, LimitDependencyModel)
        emitattrs (7, OperationalLimitSet)
        emitattrs (8, OperationalRestrictions)
        emitattrs (9, Outages)
        emitattrs (10, PinEquipment)
        emitattrs (11, ProtectiveActionEquipment)
        emitattrs (12, UsagePoints)
        emitattrs (13, WeatherStation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Equipment rdf:ID=\"%s\">\n%s\t</cim:Equipment>".format (id, export_fields)
    }
}

object Equipment
extends
    Parseable[Equipment]
{
    override val fields: Array[String] = Array[String] (
        "aggregate",
        "normallyInService",
        "ContingencyEquipment",
        "EqiupmentLimitSeriesComponent",
        "EquipmentContainer",
        "Faults",
        "LimitDependencyModel",
        "OperationalLimitSet",
        "OperationalRestrictions",
        "Outages",
        "PinEquipment",
        "ProtectiveActionEquipment",
        "UsagePoints",
        "WeatherStation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ContingencyEquipment", "ContingencyEquipment", "0..*", "1"),
        Relationship ("EqiupmentLimitSeriesComponent", "EquipmentLimitSeriesComponent", "0..*", "1"),
        Relationship ("EquipmentContainer", "EquipmentContainer", "0..1", "0..*"),
        Relationship ("Faults", "Fault", "0..*", "0..1"),
        Relationship ("LimitDependencyModel", "LimitDependency", "0..*", "0..1"),
        Relationship ("OperationalLimitSet", "OperationalLimitSet", "0..*", "0..1"),
        Relationship ("OperationalRestrictions", "OperationalRestriction", "0..*", "0..*"),
        Relationship ("Outages", "Outage", "0..*", "0..*"),
        Relationship ("PinEquipment", "PinEquipment", "0..*", "1"),
        Relationship ("ProtectiveActionEquipment", "ProtectiveActionEquipment", "0..*", "1"),
        Relationship ("UsagePoints", "UsagePoint", "0..*", "0..*"),
        Relationship ("WeatherStation", "WeatherStation", "0..*", "0..*")
    )
    val aggregate: Fielder = parse_element (element (cls, fields(0)))
    val normallyInService: Fielder = parse_element (element (cls, fields(1)))
    val ContingencyEquipment: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val EqiupmentLimitSeriesComponent: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val EquipmentContainer: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Faults: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val LimitDependencyModel: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val OperationalLimitSet: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val OperationalRestrictions: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val Outages: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val PinEquipment: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val ProtectiveActionEquipment: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val UsagePoints: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val WeatherStation: FielderMultiple = parse_attributes (attribute (cls, fields(13)))

    def parse (context: Context): Equipment =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Equipment (
            PowerSystemResource.parse (context),
            toBoolean (mask (aggregate (), 0)),
            toBoolean (mask (normallyInService (), 1)),
            masks (ContingencyEquipment (), 2),
            masks (EqiupmentLimitSeriesComponent (), 3),
            mask (EquipmentContainer (), 4),
            masks (Faults (), 5),
            masks (LimitDependencyModel (), 6),
            masks (OperationalLimitSet (), 7),
            masks (OperationalRestrictions (), 8),
            masks (Outages (), 9),
            masks (PinEquipment (), 10),
            masks (ProtectiveActionEquipment (), 11),
            masks (UsagePoints (), 12),
            masks (WeatherStation (), 13)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A modeling construct to provide a root class for containing equipment.
 *
 * @param sup [[ch.ninecode.model.ConnectivityNodeContainer ConnectivityNodeContainer]] Reference to the superclass object.
 * @param Equipments [[ch.ninecode.model.Equipment Equipment]] Contained equipment.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class EquipmentContainer
(
    override val sup: ConnectivityNodeContainer,
    Equipments: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ConnectivityNodeContainer: ConnectivityNodeContainer = sup.asInstanceOf[ConnectivityNodeContainer]
    override def copy (): Row = { clone ().asInstanceOf[EquipmentContainer] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EquipmentContainer.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (EquipmentContainer.fields (position), x))
        emitattrs (0, Equipments)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EquipmentContainer rdf:ID=\"%s\">\n%s\t</cim:EquipmentContainer>".format (id, export_fields)
    }
}

object EquipmentContainer
extends
    Parseable[EquipmentContainer]
{
    override val fields: Array[String] = Array[String] (
        "Equipments"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Equipments", "Equipment", "0..*", "0..1")
    )
    val Equipments: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): EquipmentContainer =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = EquipmentContainer (
            ConnectivityNodeContainer.parse (context),
            masks (Equipments (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A geographical region of a power system network model.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Regions [[ch.ninecode.model.SubGeographicalRegion SubGeographicalRegion]] All sub-geograhpical regions within this geographical region.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class GeographicalRegion
(
    override val sup: IdentifiedObject,
    Regions: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[GeographicalRegion] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GeographicalRegion.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (GeographicalRegion.fields (position), x))
        emitattrs (0, Regions)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GeographicalRegion rdf:ID=\"%s\">\n%s\t</cim:GeographicalRegion>".format (id, export_fields)
    }
}

object GeographicalRegion
extends
    Parseable[GeographicalRegion]
{
    override val fields: Array[String] = Array[String] (
        "Regions"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Regions", "SubGeographicalRegion", "0..*", "0..1")
    )
    val Regions: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): GeographicalRegion =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = GeographicalRegion (
            IdentifiedObject.parse (context),
            masks (Regions (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This is a root class to provide common identification for all classes needing identification and naming attributes.
 *
 * @param sup Reference to the superclass object.
 * @param aliasName The aliasName is free text human readable name of the object alternative to IdentifiedObject.name.
 *        It may be non unique and may not correlate to a naming hierarchy.
 * @param description The description is a free human readable text describing or naming the object.
 *        It may be non unique and may not correlate to a naming hierarchy.
 * @param mRID Master resource identifier issued by a model authority.
 *        The mRID is globally unique within an exchange context. Global uniqueness is easily achieved by using a UUID,  as specified in RFC 4122, for the mRID.  The use of UUID is strongly recommended.
 * @param name The name is any free human readable and possibly non unique text naming the object.
 * @param DiagramObjects [[ch.ninecode.model.DiagramObject DiagramObject]] The diagram objects that are associated with the domain object.
 * @param Names [[ch.ninecode.model.Name Name]] All names of this identified object.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class IdentifiedObject
(
    override val sup: BasicElement,
    aliasName: String,
    description: String,
    mRID: String,
    name: String,
    DiagramObjects: List[String],
    Names: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[IdentifiedObject] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = IdentifiedObject.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (IdentifiedObject.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (IdentifiedObject.fields (position), x))
        emitelem (0, aliasName)
        emitelem (1, description)
        emitelem (2, mRID)
        emitelem (3, name)
        emitattrs (4, DiagramObjects)
        emitattrs (5, Names)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IdentifiedObject rdf:ID=\"%s\">\n%s\t</cim:IdentifiedObject>".format (id, export_fields)
    }
}

object IdentifiedObject
extends
    Parseable[IdentifiedObject]
{
    override val fields: Array[String] = Array[String] (
        "aliasName",
        "description",
        "mRID",
        "name",
        "DiagramObjects",
        "Names"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DiagramObjects", "DiagramObject", "0..*", "0..1"),
        Relationship ("Names", "Name", "0..*", "1")
    )
    val aliasName: Fielder = parse_element (element (cls, fields(0)))
    val description: Fielder = parse_element (element (cls, fields(1)))
    val mRID: Fielder = parse_element (element (cls, fields(2)))
    val name: Fielder = parse_element (element (cls, fields(3)))
    val DiagramObjects: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Names: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): IdentifiedObject =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val base = BasicElement.parse (context)
        val ret = IdentifiedObject (
            base,
            mask (aliasName (), 0),
            mask (description (), 1),
            base.id,
            mask (name (), 3),
            masks (DiagramObjects (), 4),
            masks (Names (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The schedule has time points where the time between them varies.
 *
 * @param sup [[ch.ninecode.model.BasicIntervalSchedule BasicIntervalSchedule]] Reference to the superclass object.
 * @param TimePoints [[ch.ninecode.model.IrregularTimePoint IrregularTimePoint]] The point data values that define a curve.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class IrregularIntervalSchedule
(
    override val sup: BasicIntervalSchedule,
    TimePoints: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def BasicIntervalSchedule: BasicIntervalSchedule = sup.asInstanceOf[BasicIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[IrregularIntervalSchedule] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = IrregularIntervalSchedule.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (IrregularIntervalSchedule.fields (position), x))
        emitattrs (0, TimePoints)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IrregularIntervalSchedule rdf:ID=\"%s\">\n%s\t</cim:IrregularIntervalSchedule>".format (id, export_fields)
    }
}

object IrregularIntervalSchedule
extends
    Parseable[IrregularIntervalSchedule]
{
    override val fields: Array[String] = Array[String] (
        "TimePoints"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TimePoints", "IrregularTimePoint", "1..*", "1")
    )
    val TimePoints: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): IrregularIntervalSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = IrregularIntervalSchedule (
            BasicIntervalSchedule.parse (context),
            masks (TimePoints (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * TimePoints for a schedule where the time between the points varies.
 *
 * @param sup Reference to the superclass object.
 * @param time The time is relative to the schedule starting time.
 * @param value1 The first value at the time.
 *        The meaning of the value is defined by the derived type of the associated schedule.
 * @param value2 The second value at the time.
 *        The meaning of the value is defined by the derived type of the associated schedule.
 * @param IntervalSchedule [[ch.ninecode.model.IrregularIntervalSchedule IrregularIntervalSchedule]] An IrregularTimePoint belongs to an IrregularIntervalSchedule.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class IrregularTimePoint
(
    override val sup: BasicElement,
    time: Double,
    value1: Double,
    value2: Double,
    IntervalSchedule: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[IrregularTimePoint] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = IrregularTimePoint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (IrregularTimePoint.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (IrregularTimePoint.fields (position), value)
        emitelem (0, time)
        emitelem (1, value1)
        emitelem (2, value2)
        emitattr (3, IntervalSchedule)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IrregularTimePoint rdf:ID=\"%s\">\n%s\t</cim:IrregularTimePoint>".format (id, export_fields)
    }
}

object IrregularTimePoint
extends
    Parseable[IrregularTimePoint]
{
    override val fields: Array[String] = Array[String] (
        "time",
        "value1",
        "value2",
        "IntervalSchedule"
    )
    override val relations: List[Relationship] = List (
        Relationship ("IntervalSchedule", "IrregularIntervalSchedule", "1", "1..*")
    )
    val time: Fielder = parse_element (element (cls, fields(0)))
    val value1: Fielder = parse_element (element (cls, fields(1)))
    val value2: Fielder = parse_element (element (cls, fields(2)))
    val IntervalSchedule: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): IrregularTimePoint =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = IrregularTimePoint (
            BasicElement.parse (context),
            toDouble (mask (time (), 0)),
            toDouble (mask (value1 (), 1)),
            toDouble (mask (value2 (), 2)),
            mask (IntervalSchedule (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The Name class provides the means to define any number of human readable  names for an object.
 *
 * A name is <b>not</b> to be used for defining inter-object relationships. For inter-object relationships instead use the object identification 'mRID'.
 *
 * @param sup Reference to the superclass object.
 * @param name Any free text that name the object.
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Identified object that this name designates.
 * @param NameType [[ch.ninecode.model.NameType NameType]] Type of this name.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class Name
(
    override val sup: BasicElement,
    name: String,
    IdentifiedObject: String,
    NameType: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Name] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Name.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Name.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Name.fields (position), value)
        emitelem (0, name)
        emitattr (1, IdentifiedObject)
        emitattr (2, NameType)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Name rdf:ID=\"%s\">\n%s\t</cim:Name>".format (id, export_fields)
    }
}

object Name
extends
    Parseable[Name]
{
    override val fields: Array[String] = Array[String] (
        "name",
        "IdentifiedObject",
        "NameType"
    )
    override val relations: List[Relationship] = List (
        Relationship ("IdentifiedObject", "IdentifiedObject", "1", "0..*"),
        Relationship ("NameType", "NameType", "1", "0..*")
    )
    val name: Fielder = parse_element (element (cls, fields(0)))
    val IdentifiedObject: Fielder = parse_attribute (attribute (cls, fields(1)))
    val NameType: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): Name =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Name (
            BasicElement.parse (context),
            mask (name (), 0),
            mask (IdentifiedObject (), 1),
            mask (NameType (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Type of name.
 *
 * Possible values for attribute 'name' are implementation dependent but standard profiles may specify types. An enterprise may have multiple IT systems each having its own local name for the same object, e.g. a planning system may have different names from an EMS. An object may also have different names within the same IT system, e.g. localName as defined in CIM version 14. The definition from CIM14 is:
 *
 * @param sup Reference to the superclass object.
 * @param description Description of the name type.
 * @param name Name of the name type.
 * @param NameTypeAuthority [[ch.ninecode.model.NameTypeAuthority NameTypeAuthority]] Authority responsible for managing names of this type.
 * @param Names [[ch.ninecode.model.Name Name]] All names of this type.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class NameType
(
    override val sup: BasicElement,
    description: String,
    name: String,
    NameTypeAuthority: String,
    Names: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[NameType] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = NameType.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (NameType.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (NameType.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (NameType.fields (position), x))
        emitelem (0, description)
        emitelem (1, name)
        emitattr (2, NameTypeAuthority)
        emitattrs (3, Names)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NameType rdf:ID=\"%s\">\n%s\t</cim:NameType>".format (id, export_fields)
    }
}

object NameType
extends
    Parseable[NameType]
{
    override val fields: Array[String] = Array[String] (
        "description",
        "name",
        "NameTypeAuthority",
        "Names"
    )
    override val relations: List[Relationship] = List (
        Relationship ("NameTypeAuthority", "NameTypeAuthority", "0..1", "0..*"),
        Relationship ("Names", "Name", "0..*", "1")
    )
    val description: Fielder = parse_element (element (cls, fields(0)))
    val name: Fielder = parse_element (element (cls, fields(1)))
    val NameTypeAuthority: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Names: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): NameType =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = NameType (
            BasicElement.parse (context),
            mask (description (), 0),
            mask (name (), 1),
            mask (NameTypeAuthority (), 2),
            masks (Names (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Authority responsible for creation and management of names of a given type; typically an organization or an enterprise system.
 *
 * @param sup Reference to the superclass object.
 * @param description Description of the name type authority.
 * @param name Name of the name type authority.
 * @param NameTypes [[ch.ninecode.model.NameType NameType]] All name types managed by this authority.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class NameTypeAuthority
(
    override val sup: BasicElement,
    description: String,
    name: String,
    NameTypes: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[NameTypeAuthority] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = NameTypeAuthority.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (NameTypeAuthority.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (NameTypeAuthority.fields (position), x))
        emitelem (0, description)
        emitelem (1, name)
        emitattrs (2, NameTypes)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NameTypeAuthority rdf:ID=\"%s\">\n%s\t</cim:NameTypeAuthority>".format (id, export_fields)
    }
}

object NameTypeAuthority
extends
    Parseable[NameTypeAuthority]
{
    override val fields: Array[String] = Array[String] (
        "description",
        "name",
        "NameTypes"
    )
    override val relations: List[Relationship] = List (
        Relationship ("NameTypes", "NameType", "0..*", "0..1")
    )
    val description: Fielder = parse_element (element (cls, fields(0)))
    val name: Fielder = parse_element (element (cls, fields(1)))
    val NameTypes: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): NameTypeAuthority =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = NameTypeAuthority (
            BasicElement.parse (context),
            mask (description (), 0),
            mask (name (), 1),
            masks (NameTypes (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An operator of multiple power system resource objects.
 *
 * Note multple operating participants may operate the same power system resource object.   This can be used for modeling jointly owned units where each owner operates as a contractual share.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param OperatingShare [[ch.ninecode.model.OperatingShare OperatingShare]] The operating shares of this operating participant.
 *        An operating participant can be resused for any number of power system resources.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class OperatingParticipant
(
    override val sup: IdentifiedObject,
    OperatingShare: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[OperatingParticipant] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OperatingParticipant.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (OperatingParticipant.fields (position), x))
        emitattrs (0, OperatingShare)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OperatingParticipant rdf:ID=\"%s\">\n%s\t</cim:OperatingParticipant>".format (id, export_fields)
    }
}

object OperatingParticipant
extends
    Parseable[OperatingParticipant]
{
    override val fields: Array[String] = Array[String] (
        "OperatingShare"
    )
    override val relations: List[Relationship] = List (
        Relationship ("OperatingShare", "OperatingShare", "0..*", "1")
    )
    val OperatingShare: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): OperatingParticipant =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OperatingParticipant (
            IdentifiedObject.parse (context),
            masks (OperatingShare (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Specifies the operations contract relationship between a power system resource and a contract participant.
 *
 * @param sup Reference to the superclass object.
 * @param percentage Percentage operational ownership between the pair (power system resource and operatging participant) associated with this share.
 *        The total percentage ownership for a power system resource should add to 100%.
 * @param OperatingParticipant [[ch.ninecode.model.OperatingParticipant OperatingParticipant]] The operating participant having this share with the associated power system resource.
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] The power system resource to which the share applies.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class OperatingShare
(
    override val sup: BasicElement,
    percentage: Double,
    OperatingParticipant: String,
    PowerSystemResource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[OperatingShare] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OperatingShare.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OperatingShare.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OperatingShare.fields (position), value)
        emitelem (0, percentage)
        emitattr (1, OperatingParticipant)
        emitattr (2, PowerSystemResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OperatingShare rdf:ID=\"%s\">\n%s\t</cim:OperatingShare>".format (id, export_fields)
    }
}

object OperatingShare
extends
    Parseable[OperatingShare]
{
    override val fields: Array[String] = Array[String] (
        "percentage",
        "OperatingParticipant",
        "PowerSystemResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("OperatingParticipant", "OperatingParticipant", "1", "0..*"),
        Relationship ("PowerSystemResource", "PowerSystemResource", "1", "0..*")
    )
    val percentage: Fielder = parse_element (element (cls, fields(0)))
    val OperatingParticipant: Fielder = parse_attribute (attribute (cls, fields(1)))
    val PowerSystemResource: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): OperatingShare =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OperatingShare (
            BasicElement.parse (context),
            toDouble (mask (percentage (), 0)),
            mask (OperatingParticipant (), 1),
            mask (PowerSystemResource (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Classifying instances of the same class, e.g. overhead and underground ACLineSegments.
 *
 * This classification mechanism is intended to provide flexibility outside the scope of this standard, i.e. provide customisation that is non standard.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param PowerSystemResources [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Power system resources classified with this power system resource type.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class PSRType
(
    override val sup: IdentifiedObject,
    PowerSystemResources: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[PSRType] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PSRType.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (PSRType.fields (position), x))
        emitattrs (0, PowerSystemResources)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PSRType rdf:ID=\"%s\">\n%s\t</cim:PSRType>".format (id, export_fields)
    }
}

object PSRType
extends
    Parseable[PSRType]
{
    override val fields: Array[String] = Array[String] (
        "PowerSystemResources"
    )
    override val relations: List[Relationship] = List (
        Relationship ("PowerSystemResources", "PowerSystemResource", "0..*", "0..1")
    )
    val PowerSystemResources: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): PSRType =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PSRType (
            IdentifiedObject.parse (context),
            masks (PowerSystemResources (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A power system resource can be an item of equipment such as a switch, an equipment container containing many individual items of equipment such as a substation, or an organisational entity such as sub-control area.
 *
 * Power system resources can have measurements associated.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param AssetDatasheet [[ch.ninecode.model.AssetInfo AssetInfo]] Datasheet information for this power system resource.
 * @param Assets [[ch.ninecode.model.Asset Asset]] All assets represented by this power system resource.
 *        For example, multiple conductor assets are electrically modelled as a single AC line segment.
 * @param Clearances [[ch.ninecode.model.ClearanceDocument ClearanceDocument]] All clearances applicable to this power system resource.
 * @param Controls [[ch.ninecode.model.Control Control]] The controller outputs used to actually govern a regulating device, e.g. the magnetization of a synchronous machine or capacitor bank breaker actuator.
 * @param Location [[ch.ninecode.model.Location Location]] Location of this power system resource.
 * @param Measurements [[ch.ninecode.model.Measurement Measurement]] The measurements associated with this power system resource.
 * @param OperatingShare [[ch.ninecode.model.OperatingShare OperatingShare]] The operating shares of this power system resource.
 * @param OperationTags [[ch.ninecode.model.OperationTag OperationTag]] All operation tags placed on this power system resource.
 * @param PSREvents [[ch.ninecode.model.PSREvent PSREvent]] All events associated with this power system resource.
 * @param PSRType [[ch.ninecode.model.PSRType PSRType]] Custom classification for this power system resource.
 * @param ReportingGroup [[ch.ninecode.model.ReportingGroup ReportingGroup]] Reporting groups to which this power system resource belongs.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class PowerSystemResource
(
    override val sup: IdentifiedObject,
    AssetDatasheet: String,
    Assets: List[String],
    Clearances: List[String],
    Controls: List[String],
    Location: String,
    Measurements: List[String],
    OperatingShare: List[String],
    OperationTags: List[String],
    PSREvents: List[String],
    PSRType: String,
    ReportingGroup: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), List(), List(), null, List(), List(), List(), List(), null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[PowerSystemResource] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PowerSystemResource.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PowerSystemResource.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (PowerSystemResource.fields (position), x))
        emitattr (0, AssetDatasheet)
        emitattrs (1, Assets)
        emitattrs (2, Clearances)
        emitattrs (3, Controls)
        emitattr (4, Location)
        emitattrs (5, Measurements)
        emitattrs (6, OperatingShare)
        emitattrs (7, OperationTags)
        emitattrs (8, PSREvents)
        emitattr (9, PSRType)
        emitattrs (10, ReportingGroup)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PowerSystemResource rdf:ID=\"%s\">\n%s\t</cim:PowerSystemResource>".format (id, export_fields)
    }
}

object PowerSystemResource
extends
    Parseable[PowerSystemResource]
{
    override val fields: Array[String] = Array[String] (
        "AssetDatasheet",
        "Assets",
        "Clearances",
        "Controls",
        "Location",
        "Measurements",
        "OperatingShare",
        "OperationTags",
        "PSREvents",
        "PSRType",
        "ReportingGroup"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AssetDatasheet", "AssetInfo", "0..1", "0..*"),
        Relationship ("Assets", "Asset", "0..*", "0..*"),
        Relationship ("Clearances", "ClearanceDocument", "0..*", "0..*"),
        Relationship ("Controls", "Control", "0..*", "0..1"),
        Relationship ("Location", "Location", "0..1", "0..*"),
        Relationship ("Measurements", "Measurement", "0..*", "0..1"),
        Relationship ("OperatingShare", "OperatingShare", "0..*", "1"),
        Relationship ("OperationTags", "OperationTag", "0..*", "0..1"),
        Relationship ("PSREvents", "PSREvent", "0..*", "0..1"),
        Relationship ("PSRType", "PSRType", "0..1", "0..*"),
        Relationship ("ReportingGroup", "ReportingGroup", "0..*", "0..*")
    )
    val AssetDatasheet: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Clearances: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Controls: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Location: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Measurements: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val OperatingShare: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val OperationTags: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val PSREvents: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val PSRType: Fielder = parse_attribute (attribute (cls, fields(9)))
    val ReportingGroup: FielderMultiple = parse_attributes (attribute (cls, fields(10)))

    def parse (context: Context): PowerSystemResource =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PowerSystemResource (
            IdentifiedObject.parse (context),
            mask (AssetDatasheet (), 0),
            masks (Assets (), 1),
            masks (Clearances (), 2),
            masks (Controls (), 3),
            mask (Location (), 4),
            masks (Measurements (), 5),
            masks (OperatingShare (), 6),
            masks (OperationTags (), 7),
            masks (PSREvents (), 8),
            mask (PSRType (), 9),
            masks (ReportingGroup (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The schedule has time points where the time between them is constant.
 *
 * @param sup [[ch.ninecode.model.BasicIntervalSchedule BasicIntervalSchedule]] Reference to the superclass object.
 * @param endTime The time for the last time point.
 * @param timeStep The time between each pair of subsequent regular time points in sequence order.
 * @param TimePoints [[ch.ninecode.model.RegularTimePoint RegularTimePoint]] The regular interval time point data values that define this schedule.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class RegularIntervalSchedule
(
    override val sup: BasicIntervalSchedule,
    endTime: String,
    timeStep: Double,
    TimePoints: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def BasicIntervalSchedule: BasicIntervalSchedule = sup.asInstanceOf[BasicIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[RegularIntervalSchedule] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RegularIntervalSchedule.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegularIntervalSchedule.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (RegularIntervalSchedule.fields (position), x))
        emitelem (0, endTime)
        emitelem (1, timeStep)
        emitattrs (2, TimePoints)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RegularIntervalSchedule rdf:ID=\"%s\">\n%s\t</cim:RegularIntervalSchedule>".format (id, export_fields)
    }
}

object RegularIntervalSchedule
extends
    Parseable[RegularIntervalSchedule]
{
    override val fields: Array[String] = Array[String] (
        "endTime",
        "timeStep",
        "TimePoints"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TimePoints", "RegularTimePoint", "1..*", "1")
    )
    val endTime: Fielder = parse_element (element (cls, fields(0)))
    val timeStep: Fielder = parse_element (element (cls, fields(1)))
    val TimePoints: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): RegularIntervalSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RegularIntervalSchedule (
            BasicIntervalSchedule.parse (context),
            mask (endTime (), 0),
            toDouble (mask (timeStep (), 1)),
            masks (TimePoints (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Time point for a schedule where the time between the consecutive points is constant.
 *
 * @param sup Reference to the superclass object.
 * @param sequenceNumber The position of the regular time point in the sequence.
 *        Note that time points don't have to be sequential, i.e. time points may be omitted. The actual time for a RegularTimePoint is computed by multiplying the associated regular interval schedule's time step with the regular time point sequence number and adding the associated schedules start time.
 * @param value1 The first value at the time.
 *        The meaning of the value is defined by the derived type of the associated schedule.
 * @param value2 The second value at the time.
 *        The meaning of the value is defined by the derived type of the associated schedule.
 * @param IntervalSchedule [[ch.ninecode.model.RegularIntervalSchedule RegularIntervalSchedule]] Regular interval schedule containing this time point.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class RegularTimePoint
(
    override val sup: BasicElement,
    sequenceNumber: Int,
    value1: Double,
    value2: Double,
    IntervalSchedule: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[RegularTimePoint] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RegularTimePoint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RegularTimePoint.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RegularTimePoint.fields (position), value)
        emitelem (0, sequenceNumber)
        emitelem (1, value1)
        emitelem (2, value2)
        emitattr (3, IntervalSchedule)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RegularTimePoint rdf:ID=\"%s\">\n%s\t</cim:RegularTimePoint>".format (id, export_fields)
    }
}

object RegularTimePoint
extends
    Parseable[RegularTimePoint]
{
    override val fields: Array[String] = Array[String] (
        "sequenceNumber",
        "value1",
        "value2",
        "IntervalSchedule"
    )
    override val relations: List[Relationship] = List (
        Relationship ("IntervalSchedule", "RegularIntervalSchedule", "1", "1..*")
    )
    val sequenceNumber: Fielder = parse_element (element (cls, fields(0)))
    val value1: Fielder = parse_element (element (cls, fields(1)))
    val value2: Fielder = parse_element (element (cls, fields(2)))
    val IntervalSchedule: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): RegularTimePoint =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RegularTimePoint (
            BasicElement.parse (context),
            toInteger (mask (sequenceNumber (), 0)),
            toDouble (mask (value1 (), 1)),
            toDouble (mask (value2 (), 2)),
            mask (IntervalSchedule (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A reporting group is used for various ad-hoc groupings used for reporting.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param BusNameMarker [[ch.ninecode.model.BusNameMarker BusNameMarker]] The bus name markers that belong to this reporting group.
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Power system resources which belong to this reporting group.
 * @param ReportingSuperGroup [[ch.ninecode.model.ReportingSuperGroup ReportingSuperGroup]] Reporting super group to which this reporting group belongs.
 * @param TopologicalNode [[ch.ninecode.model.TopologicalNode TopologicalNode]] The topological nodes that belong to the reporting group.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class ReportingGroup
(
    override val sup: IdentifiedObject,
    BusNameMarker: List[String],
    PowerSystemResource: List[String],
    ReportingSuperGroup: String,
    TopologicalNode: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List(), null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ReportingGroup] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ReportingGroup.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ReportingGroup.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ReportingGroup.fields (position), x))
        emitattrs (0, BusNameMarker)
        emitattrs (1, PowerSystemResource)
        emitattr (2, ReportingSuperGroup)
        emitattrs (3, TopologicalNode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ReportingGroup rdf:ID=\"%s\">\n%s\t</cim:ReportingGroup>".format (id, export_fields)
    }
}

object ReportingGroup
extends
    Parseable[ReportingGroup]
{
    override val fields: Array[String] = Array[String] (
        "BusNameMarker",
        "PowerSystemResource",
        "ReportingSuperGroup",
        "TopologicalNode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("BusNameMarker", "BusNameMarker", "0..*", "0..1"),
        Relationship ("PowerSystemResource", "PowerSystemResource", "0..*", "0..*"),
        Relationship ("ReportingSuperGroup", "ReportingSuperGroup", "0..1", "0..*"),
        Relationship ("TopologicalNode", "TopologicalNode", "0..*", "0..1")
    )
    val BusNameMarker: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val PowerSystemResource: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val ReportingSuperGroup: Fielder = parse_attribute (attribute (cls, fields(2)))
    val TopologicalNode: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): ReportingGroup =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ReportingGroup (
            IdentifiedObject.parse (context),
            masks (BusNameMarker (), 0),
            masks (PowerSystemResource (), 1),
            mask (ReportingSuperGroup (), 2),
            masks (TopologicalNode (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A reporting super group, groups reporting groups for a higher level report.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ReportingGroup [[ch.ninecode.model.ReportingGroup ReportingGroup]] Reporting groups that are grouped under this super group.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class ReportingSuperGroup
(
    override val sup: IdentifiedObject,
    ReportingGroup: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ReportingSuperGroup] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ReportingSuperGroup.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ReportingSuperGroup.fields (position), x))
        emitattrs (0, ReportingGroup)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ReportingSuperGroup rdf:ID=\"%s\">\n%s\t</cim:ReportingSuperGroup>".format (id, export_fields)
    }
}

object ReportingSuperGroup
extends
    Parseable[ReportingSuperGroup]
{
    override val fields: Array[String] = Array[String] (
        "ReportingGroup"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ReportingGroup", "ReportingGroup", "0..*", "0..1")
    )
    val ReportingGroup: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): ReportingSuperGroup =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ReportingSuperGroup (
            IdentifiedObject.parse (context),
            masks (ReportingGroup (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A subset of a geographical region of a power system network model.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param DCLines [[ch.ninecode.model.DCLine DCLine]] <em>undocumented</em>
 * @param Lines [[ch.ninecode.model.Line Line]] The lines within the sub-geographical region.
 * @param Region [[ch.ninecode.model.GeographicalRegion GeographicalRegion]] The geographical region to which this sub-geographical region is within.
 * @param Substations [[ch.ninecode.model.Substation Substation]] The substations in this sub-geographical region.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class SubGeographicalRegion
(
    override val sup: IdentifiedObject,
    DCLines: List[String],
    Lines: List[String],
    Region: String,
    Substations: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List(), null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[SubGeographicalRegion] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SubGeographicalRegion.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SubGeographicalRegion.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (SubGeographicalRegion.fields (position), x))
        emitattrs (0, DCLines)
        emitattrs (1, Lines)
        emitattr (2, Region)
        emitattrs (3, Substations)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SubGeographicalRegion rdf:ID=\"%s\">\n%s\t</cim:SubGeographicalRegion>".format (id, export_fields)
    }
}

object SubGeographicalRegion
extends
    Parseable[SubGeographicalRegion]
{
    override val fields: Array[String] = Array[String] (
        "DCLines",
        "Lines",
        "Region",
        "Substations"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DCLines", "DCLine", "0..*", "0..1"),
        Relationship ("Lines", "Line", "0..*", "0..1"),
        Relationship ("Region", "GeographicalRegion", "0..1", "0..*"),
        Relationship ("Substations", "Substation", "0..*", "0..1")
    )
    val DCLines: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val Lines: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Region: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Substations: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): SubGeographicalRegion =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SubGeographicalRegion (
            IdentifiedObject.parse (context),
            masks (DCLines (), 0),
            masks (Lines (), 1),
            mask (Region (), 2),
            masks (Substations (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A collection of equipment for purposes other than generation or utilization, through which electric energy in bulk is passed for the purposes of switching or modifying its characteristics.
 *
 * @param sup [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Reference to the superclass object.
 * @param Bays [[ch.ninecode.model.Bay Bay]] Bays contained in the substation.
 * @param DCConverterUnit [[ch.ninecode.model.DCConverterUnit DCConverterUnit]] <em>undocumented</em>
 * @param Region [[ch.ninecode.model.SubGeographicalRegion SubGeographicalRegion]] The SubGeographicalRegion containing the substation.
 * @param VoltageLevels [[ch.ninecode.model.VoltageLevel VoltageLevel]] The voltage levels within this substation.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class Substation
(
    override val sup: EquipmentContainer,
    Bays: List[String],
    DCConverterUnit: List[String],
    Region: String,
    VoltageLevels: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List(), null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { clone ().asInstanceOf[Substation] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Substation.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Substation.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Substation.fields (position), x))
        emitattrs (0, Bays)
        emitattrs (1, DCConverterUnit)
        emitattr (2, Region)
        emitattrs (3, VoltageLevels)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Substation rdf:ID=\"%s\">\n%s\t</cim:Substation>".format (id, export_fields)
    }
}

object Substation
extends
    Parseable[Substation]
{
    override val fields: Array[String] = Array[String] (
        "Bays",
        "DCConverterUnit",
        "Region",
        "VoltageLevels"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Bays", "Bay", "0..*", "0..1"),
        Relationship ("DCConverterUnit", "DCConverterUnit", "0..*", "0..1"),
        Relationship ("Region", "SubGeographicalRegion", "0..1", "0..*"),
        Relationship ("VoltageLevels", "VoltageLevel", "0..*", "1")
    )
    val Bays: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val DCConverterUnit: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Region: Fielder = parse_attribute (attribute (cls, fields(2)))
    val VoltageLevels: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): Substation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Substation (
            EquipmentContainer.parse (context),
            masks (Bays (), 0),
            masks (DCConverterUnit (), 1),
            mask (Region (), 2),
            masks (VoltageLevels (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An AC electrical connection point to a piece of conducting equipment.
 *
 * Terminals are connected at physical connection points called connectivity nodes.
 *
 * @param sup [[ch.ninecode.model.ACDCTerminal ACDCTerminal]] Reference to the superclass object.
 * @param phases Represents the normal network phasing condition.
 *        If the attribute is missing three phases (ABC or ABCN) shall be assumed.
 * @param AuxiliaryEquipment [[ch.ninecode.model.AuxiliaryEquipment AuxiliaryEquipment]] The auxiliary equipment connected to the terminal.
 * @param BranchGroupTerminal [[ch.ninecode.model.BranchGroupTerminal BranchGroupTerminal]] The directed branch group terminals for which this terminal is monitored.
 * @param Bushing [[ch.ninecode.model.Bushing Bushing]] <em>undocumented</em>
 * @param ConductingEquipment [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] The conducting equipment of the terminal.
 *        Conducting equipment have  terminals that may be connected to other conducting equipment terminals via connectivity nodes or topological nodes.
 * @param ConnectivityNode [[ch.ninecode.model.ConnectivityNode ConnectivityNode]] The connectivity node to which this terminal connects with zero impedance.
 * @param ConverterDCSides [[ch.ninecode.model.ACDCConverter ACDCConverter]] All converters' DC sides linked to this point of common coupling terminal.
 * @param EquipmentFaults [[ch.ninecode.model.EquipmentFault EquipmentFault]] The equipment faults at this terminal.
 * @param HasFirstMutualCoupling [[ch.ninecode.model.MutualCoupling MutualCoupling]] Mutual couplings associated with the branch as the first branch.
 * @param HasSecondMutualCoupling [[ch.ninecode.model.MutualCoupling MutualCoupling]] Mutual couplings with the branch associated as the first branch.
 * @param PinTerminal [[ch.ninecode.model.PinTerminal PinTerminal]] <em>undocumented</em>
 * @param RegulatingControl [[ch.ninecode.model.RegulatingControl RegulatingControl]] The controls regulating this terminal.
 * @param RemoteInputSignal [[ch.ninecode.model.RemoteInputSignal RemoteInputSignal]] Input signal coming from this terminal.
 * @param SvPowerFlow [[ch.ninecode.model.SvPowerFlow SvPowerFlow]] The power flow state variable associated with the terminal.
 * @param TieFlow [[ch.ninecode.model.TieFlow TieFlow]] The control area tie flows to which this terminal associates.
 * @param TopologicalNode [[ch.ninecode.model.TopologicalNode TopologicalNode]] The topological node associated with the terminal.
 *        This can be used as an alternative to the connectivity node path to topological node, thus making it unneccesary to model connectivity nodes in some cases.   Note that the if connectivity nodes are in the model, this association would probably not be used as an input specification.
 * @param TransformerEnd [[ch.ninecode.model.TransformerEnd TransformerEnd]] All transformer ends connected at this terminal.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class Terminal
(
    override val sup: ACDCTerminal,
    phases: String,
    AuxiliaryEquipment: List[String],
    BranchGroupTerminal: List[String],
    Bushing: String,
    ConductingEquipment: String,
    ConnectivityNode: String,
    ConverterDCSides: List[String],
    EquipmentFaults: List[String],
    HasFirstMutualCoupling: List[String],
    HasSecondMutualCoupling: List[String],
    PinTerminal: List[String],
    RegulatingControl: List[String],
    RemoteInputSignal: List[String],
    SvPowerFlow: String,
    TieFlow: List[String],
    TopologicalNode: String,
    TransformerEnd: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), List(), null, null, null, List(), List(), List(), List(), List(), List(), List(), null, List(), null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ACDCTerminal: ACDCTerminal = sup.asInstanceOf[ACDCTerminal]
    override def copy (): Row = { clone ().asInstanceOf[Terminal] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Terminal.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Terminal.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Terminal.fields (position), x))
        emitattr (0, phases)
        emitattrs (1, AuxiliaryEquipment)
        emitattrs (2, BranchGroupTerminal)
        emitattr (3, Bushing)
        emitattr (4, ConductingEquipment)
        emitattr (5, ConnectivityNode)
        emitattrs (6, ConverterDCSides)
        emitattrs (7, EquipmentFaults)
        emitattrs (8, HasFirstMutualCoupling)
        emitattrs (9, HasSecondMutualCoupling)
        emitattrs (10, PinTerminal)
        emitattrs (11, RegulatingControl)
        emitattrs (12, RemoteInputSignal)
        emitattr (13, SvPowerFlow)
        emitattrs (14, TieFlow)
        emitattr (15, TopologicalNode)
        emitattrs (16, TransformerEnd)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Terminal rdf:ID=\"%s\">\n%s\t</cim:Terminal>".format (id, export_fields)
    }
}

object Terminal
extends
    Parseable[Terminal]
{
    override val fields: Array[String] = Array[String] (
        "phases",
        "AuxiliaryEquipment",
        "BranchGroupTerminal",
        "Bushing",
        "ConductingEquipment",
        "ConnectivityNode",
        "ConverterDCSides",
        "EquipmentFaults",
        "HasFirstMutualCoupling",
        "HasSecondMutualCoupling",
        "PinTerminal",
        "RegulatingControl",
        "RemoteInputSignal",
        "SvPowerFlow",
        "TieFlow",
        "TopologicalNode",
        "TransformerEnd"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AuxiliaryEquipment", "AuxiliaryEquipment", "0..*", "1"),
        Relationship ("BranchGroupTerminal", "BranchGroupTerminal", "0..*", "1"),
        Relationship ("Bushing", "Bushing", "0..1", "0..1"),
        Relationship ("ConductingEquipment", "ConductingEquipment", "1", "0..*"),
        Relationship ("ConnectivityNode", "ConnectivityNode", "0..1", "0..*"),
        Relationship ("ConverterDCSides", "ACDCConverter", "0..*", "0..1"),
        Relationship ("EquipmentFaults", "EquipmentFault", "0..*", "0..1"),
        Relationship ("HasFirstMutualCoupling", "MutualCoupling", "0..*", "1"),
        Relationship ("HasSecondMutualCoupling", "MutualCoupling", "0..*", "1"),
        Relationship ("PinTerminal", "PinTerminal", "0..*", "1"),
        Relationship ("RegulatingControl", "RegulatingControl", "0..*", "0..1"),
        Relationship ("RemoteInputSignal", "RemoteInputSignal", "0..*", "1"),
        Relationship ("SvPowerFlow", "SvPowerFlow", "0..1", "1"),
        Relationship ("TieFlow", "TieFlow", "0..2", "1"),
        Relationship ("TopologicalNode", "TopologicalNode", "0..1", "0..*"),
        Relationship ("TransformerEnd", "TransformerEnd", "0..*", "0..1")
    )
    val phases: Fielder = parse_attribute (attribute (cls, fields(0)))
    val AuxiliaryEquipment: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val BranchGroupTerminal: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Bushing: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ConductingEquipment: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ConnectivityNode: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ConverterDCSides: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val EquipmentFaults: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val HasFirstMutualCoupling: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val HasSecondMutualCoupling: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val PinTerminal: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val RegulatingControl: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val RemoteInputSignal: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val SvPowerFlow: Fielder = parse_attribute (attribute (cls, fields(13)))
    val TieFlow: FielderMultiple = parse_attributes (attribute (cls, fields(14)))
    val TopologicalNode: Fielder = parse_attribute (attribute (cls, fields(15)))
    val TransformerEnd: FielderMultiple = parse_attributes (attribute (cls, fields(16)))

    def parse (context: Context): Terminal =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Terminal (
            ACDCTerminal.parse (context),
            mask (phases (), 0),
            masks (AuxiliaryEquipment (), 1),
            masks (BranchGroupTerminal (), 2),
            mask (Bushing (), 3),
            mask (ConductingEquipment (), 4),
            mask (ConnectivityNode (), 5),
            masks (ConverterDCSides (), 6),
            masks (EquipmentFaults (), 7),
            masks (HasFirstMutualCoupling (), 8),
            masks (HasSecondMutualCoupling (), 9),
            masks (PinTerminal (), 10),
            masks (RegulatingControl (), 11),
            masks (RemoteInputSignal (), 12),
            mask (SvPowerFlow (), 13),
            masks (TieFlow (), 14),
            mask (TopologicalNode (), 15),
            masks (TransformerEnd (), 16)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A collection of equipment at one common system voltage forming a switchgear.
 *
 * The equipment typically consist of breakers, busbars, instrumentation, control, regulation and protection devices as well as assemblies of all these.
 *
 * @param sup [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Reference to the superclass object.
 * @param highVoltageLimit The bus bar's high voltage limit
 * @param lowVoltageLimit The bus bar's low voltage limit
 * @param BaseVoltage [[ch.ninecode.model.BaseVoltage BaseVoltage]] The base voltage used for all equipment within the voltage level.
 * @param Bays [[ch.ninecode.model.Bay Bay]] The bays within this voltage level.
 * @param Substation [[ch.ninecode.model.Substation Substation]] The substation of the voltage level.
 * @group Core
 * @groupname Core Package Core
 * @groupdesc Core Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities. Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 */
case class VoltageLevel
(
    override val sup: EquipmentContainer,
    highVoltageLimit: Double,
    lowVoltageLimit: Double,
    BaseVoltage: String,
    Bays: List[String],
    Substation: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { clone ().asInstanceOf[VoltageLevel] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = VoltageLevel.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VoltageLevel.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (VoltageLevel.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (VoltageLevel.fields (position), x))
        emitelem (0, highVoltageLimit)
        emitelem (1, lowVoltageLimit)
        emitattr (2, BaseVoltage)
        emitattrs (3, Bays)
        emitattr (4, Substation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VoltageLevel rdf:ID=\"%s\">\n%s\t</cim:VoltageLevel>".format (id, export_fields)
    }
}

object VoltageLevel
extends
    Parseable[VoltageLevel]
{
    override val fields: Array[String] = Array[String] (
        "highVoltageLimit",
        "lowVoltageLimit",
        "BaseVoltage",
        "Bays",
        "Substation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("BaseVoltage", "BaseVoltage", "1", "0..*"),
        Relationship ("Bays", "Bay", "0..*", "0..1"),
        Relationship ("Substation", "Substation", "1", "0..*")
    )
    val highVoltageLimit: Fielder = parse_element (element (cls, fields(0)))
    val lowVoltageLimit: Fielder = parse_element (element (cls, fields(1)))
    val BaseVoltage: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Bays: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Substation: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): VoltageLevel =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = VoltageLevel (
            EquipmentContainer.parse (context),
            toDouble (mask (highVoltageLimit (), 0)),
            toDouble (mask (lowVoltageLimit (), 1)),
            mask (BaseVoltage (), 2),
            masks (Bays (), 3),
            mask (Substation (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _Core
{
    def register: List[ClassInfo] =
    {
        List (
            ACDCTerminal.register,
            BaseFrequency.register,
            BasePower.register,
            BaseVoltage.register,
            BasicIntervalSchedule.register,
            Bay.register,
            ConductingEquipment.register,
            ConnectivityNode.register,
            ConnectivityNodeContainer.register,
            Curve.register,
            CurveData.register,
            Equipment.register,
            EquipmentContainer.register,
            GeographicalRegion.register,
            IdentifiedObject.register,
            IrregularIntervalSchedule.register,
            IrregularTimePoint.register,
            Name.register,
            NameType.register,
            NameTypeAuthority.register,
            OperatingParticipant.register,
            OperatingShare.register,
            PSRType.register,
            PowerSystemResource.register,
            RegularIntervalSchedule.register,
            RegularTimePoint.register,
            ReportingGroup.register,
            ReportingSuperGroup.register,
            SubGeographicalRegion.register,
            Substation.register,
            Terminal.register,
            VoltageLevel.register
        )
    }
}