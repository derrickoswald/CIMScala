package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * Catalogue of available types of products and materials that are used to build or install, maintain or operate an Asset.
 *
 * Each catalogue item is for a specific product (AssetModel) available from a specific supplier.
 *
 * @param IdentifiedObject         [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status                   <em>undocumented</em>
 * @param AssetModelCatalogueItems [[ch.ninecode.model.AssetModelCatalogueItem AssetModelCatalogueItem]] <em>undocumented</em>
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
final case class AssetModelCatalogue
(
    IdentifiedObject: IdentifiedObject = null,
    status: String = null,
    AssetModelCatalogueItems: List[String] = null
)
    extends
        Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = AssetModelCatalogue.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(AssetModelCatalogue.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(AssetModelCatalogue.fields(position), x))

        emitattr(0, status)
        emitattrs(1, AssetModelCatalogueItems)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:AssetModelCatalogue rdf:%s=\"%s\">\n%s\t</cim:AssetModelCatalogue>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object AssetModelCatalogue
    extends
        CIMParseable[AssetModelCatalogue]
{
    override val fields: Array[String] = Array[String](
        "status",
        "AssetModelCatalogueItems"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("AssetModelCatalogueItems", "AssetModelCatalogueItem", "0..*", "1")
    )
    val status: Fielder = parse_attribute(attribute(cls, fields(0)))
    val AssetModelCatalogueItems: FielderMultiple = parse_attributes(attribute(cls, fields(1)))

    def parse (context: CIMContext): AssetModelCatalogue =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AssetModelCatalogue(
            IdentifiedObject.parse(context),
            mask(status(), 0),
            masks(AssetModelCatalogueItems(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AssetModelCatalogue] = AssetModelCatalogueSerializer
}

object AssetModelCatalogueSerializer extends CIMSerializer[AssetModelCatalogue]
{
    def write (kryo: Kryo, output: Output, obj: AssetModelCatalogue): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.status),
            () => writeList(obj.AssetModelCatalogueItems, output)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssetModelCatalogue]): AssetModelCatalogue =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = AssetModelCatalogue(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Provides pricing and other relevant information about a specific manufacturer's product (i.e., AssetModel), and its price from a given supplier.
 *
 * A single AssetModel may be availble from multiple suppliers. Note that manufacturer and supplier are both types of organisation, which the association is inherited from Document.
 *
 * @param Document            [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param unitCost            Unit cost for an asset model from a specific supplier, either for a unit cost or cost per unit length.
 *                            Cost is for material or asset only and does not include labor to install/construct or configure it.
 * @param AssetModel          [[ch.ninecode.model.ProductAssetModel ProductAssetModel]] <em>undocumented</em>
 * @param AssetModelCatalogue [[ch.ninecode.model.AssetModelCatalogue AssetModelCatalogue]] <em>undocumented</em>
 * @param ErpPOLineItems      [[ch.ninecode.model.ErpPOLineItem ErpPOLineItem]] <em>undocumented</em>
 * @param ErpQuoteLineItems   [[ch.ninecode.model.ErpQuoteLineItem ErpQuoteLineItem]] <em>undocumented</em>
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
final case class AssetModelCatalogueItem
(
    Document: Document = null,
    unitCost: Double = 0.0,
    AssetModel: String = null,
    AssetModelCatalogue: String = null,
    ErpPOLineItems: List[String] = null,
    ErpQuoteLineItems: List[String] = null
)
    extends
        Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Document = Document

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = AssetModelCatalogueItem.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(AssetModelCatalogueItem.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(AssetModelCatalogueItem.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(AssetModelCatalogueItem.fields(position), x))

        emitelem(0, unitCost)
        emitattr(1, AssetModel)
        emitattr(2, AssetModelCatalogue)
        emitattrs(3, ErpPOLineItems)
        emitattrs(4, ErpQuoteLineItems)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:AssetModelCatalogueItem rdf:%s=\"%s\">\n%s\t</cim:AssetModelCatalogueItem>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object AssetModelCatalogueItem
    extends
        CIMParseable[AssetModelCatalogueItem]
{
    override val fields: Array[String] = Array[String](
        "unitCost",
        "AssetModel",
        "AssetModelCatalogue",
        "ErpPOLineItems",
        "ErpQuoteLineItems"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("AssetModel", "ProductAssetModel", "0..1", "0..*"),
        CIMRelationship("AssetModelCatalogue", "AssetModelCatalogue", "1", "0..*"),
        CIMRelationship("ErpPOLineItems", "ErpPOLineItem", "0..*", "0..1"),
        CIMRelationship("ErpQuoteLineItems", "ErpQuoteLineItem", "0..*", "0..1")
    )
    val unitCost: Fielder = parse_element(element(cls, fields(0)))
    val AssetModel: Fielder = parse_attribute(attribute(cls, fields(1)))
    val AssetModelCatalogue: Fielder = parse_attribute(attribute(cls, fields(2)))
    val ErpPOLineItems: FielderMultiple = parse_attributes(attribute(cls, fields(3)))
    val ErpQuoteLineItems: FielderMultiple = parse_attributes(attribute(cls, fields(4)))

    def parse (context: CIMContext): AssetModelCatalogueItem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AssetModelCatalogueItem(
            Document.parse(context),
            toDouble(mask(unitCost(), 0)),
            mask(AssetModel(), 1),
            mask(AssetModelCatalogue(), 2),
            masks(ErpPOLineItems(), 3),
            masks(ErpQuoteLineItems(), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AssetModelCatalogueItem] = AssetModelCatalogueItemSerializer
}

object AssetModelCatalogueItemSerializer extends CIMSerializer[AssetModelCatalogueItem]
{
    def write (kryo: Kryo, output: Output, obj: AssetModelCatalogueItem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.unitCost),
            () => output.writeString(obj.AssetModel),
            () => output.writeString(obj.AssetModelCatalogue),
            () => writeList(obj.ErpPOLineItems, output),
            () => writeList(obj.ErpQuoteLineItems, output)
        )
        DocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssetModelCatalogueItem]): AssetModelCatalogueItem =
    {
        val parent = DocumentSerializer.read(kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = AssetModelCatalogueItem(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) readList(input) else null,
            if (isSet(4)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Properties of breaker assets.
 *
 * @param OldSwitchInfo [[ch.ninecode.model.OldSwitchInfo OldSwitchInfo]] Reference to the superclass object.
 * @param phaseTrip     Phase trip rating.
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
final case class BreakerInfo
(
    OldSwitchInfo: OldSwitchInfo = null,
    phaseTrip: Double = 0.0
)
    extends
        Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: OldSwitchInfo = OldSwitchInfo

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = BreakerInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(BreakerInfo.fields(position), value)

        emitelem(0, phaseTrip)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:BreakerInfo rdf:%s=\"%s\">\n%s\t</cim:BreakerInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object BreakerInfo
    extends
        CIMParseable[BreakerInfo]
{
    override val fields: Array[String] = Array[String](
        "phaseTrip"
    )
    val phaseTrip: Fielder = parse_element(element(cls, fields(0)))

    def parse (context: CIMContext): BreakerInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BreakerInfo(
            OldSwitchInfo.parse(context),
            toDouble(mask(phaseTrip(), 0))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[BreakerInfo] = BreakerInfoSerializer
}

object BreakerInfoSerializer extends CIMSerializer[BreakerInfo]
{
    def write (kryo: Kryo, output: Output, obj: BreakerInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.phaseTrip)
        )
        OldSwitchInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BreakerInfo]): BreakerInfo =
    {
        val parent = OldSwitchInfoSerializer.read(kryo, input, classOf[OldSwitchInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = BreakerInfo(
            parent,
            if (isSet(0)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Properties of a composite switch.
 *
 * @param AssetInfo          [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param ganged             True if multi-phase switch controls all phases concurrently.
 * @param initOpMode         Initial operating mode, with the following values: Automatic, Manual.
 * @param interruptingRating Breaking capacity, or short circuit rating, is the maximum rated current which the device can safely interrupt at the rated voltage.
 * @param kind               Kind of composite switch.
 * @param phaseCode          Phases carried, if applicable.
 * @param phaseCount         Supported number of phases, typically 0, 1 or 3.
 * @param ratedVoltage       Rated voltage.
 * @param remote             True if device is capable of being operated by remote control.
 * @param switchStateCount   Number of switch states represented by the composite switch.
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
final case class CompositeSwitchInfo
(
    AssetInfo: AssetInfo = null,
    ganged: Boolean = false,
    initOpMode: String = null,
    interruptingRating: Double = 0.0,
    kind: String = null,
    phaseCode: String = null,
    phaseCount: Int = 0,
    ratedVoltage: Double = 0.0,
    remote: Boolean = false,
    switchStateCount: Int = 0
)
    extends
        Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: AssetInfo = AssetInfo

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = CompositeSwitchInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(CompositeSwitchInfo.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(CompositeSwitchInfo.fields(position), value)

        emitelem(0, ganged)
        emitelem(1, initOpMode)
        emitelem(2, interruptingRating)
        emitattr(3, kind)
        emitattr(4, phaseCode)
        emitelem(5, phaseCount)
        emitelem(6, ratedVoltage)
        emitelem(7, remote)
        emitelem(8, switchStateCount)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:CompositeSwitchInfo rdf:%s=\"%s\">\n%s\t</cim:CompositeSwitchInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object CompositeSwitchInfo
    extends
        CIMParseable[CompositeSwitchInfo]
{
    override val fields: Array[String] = Array[String](
        "ganged",
        "initOpMode",
        "interruptingRating",
        "kind",
        "phaseCode",
        "phaseCount",
        "ratedVoltage",
        "remote",
        "switchStateCount"
    )
    val ganged: Fielder = parse_element(element(cls, fields(0)))
    val initOpMode: Fielder = parse_element(element(cls, fields(1)))
    val interruptingRating: Fielder = parse_element(element(cls, fields(2)))
    val kind: Fielder = parse_attribute(attribute(cls, fields(3)))
    val phaseCode: Fielder = parse_attribute(attribute(cls, fields(4)))
    val phaseCount: Fielder = parse_element(element(cls, fields(5)))
    val ratedVoltage: Fielder = parse_element(element(cls, fields(6)))
    val remote: Fielder = parse_element(element(cls, fields(7)))
    val switchStateCount: Fielder = parse_element(element(cls, fields(8)))

    def parse (context: CIMContext): CompositeSwitchInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CompositeSwitchInfo(
            AssetInfo.parse(context),
            toBoolean(mask(ganged(), 0)),
            mask(initOpMode(), 1),
            toDouble(mask(interruptingRating(), 2)),
            mask(kind(), 3),
            mask(phaseCode(), 4),
            toInteger(mask(phaseCount(), 5)),
            toDouble(mask(ratedVoltage(), 6)),
            toBoolean(mask(remote(), 7)),
            toInteger(mask(switchStateCount(), 8))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CompositeSwitchInfo] = CompositeSwitchInfoSerializer
}

object CompositeSwitchInfoSerializer extends CIMSerializer[CompositeSwitchInfo]
{
    def write (kryo: Kryo, output: Output, obj: CompositeSwitchInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeBoolean(obj.ganged),
            () => output.writeString(obj.initOpMode),
            () => output.writeDouble(obj.interruptingRating),
            () => output.writeString(obj.kind),
            () => output.writeString(obj.phaseCode),
            () => output.writeInt(obj.phaseCount),
            () => output.writeDouble(obj.ratedVoltage),
            () => output.writeBoolean(obj.remote),
            () => output.writeInt(obj.switchStateCount)
        )
        AssetInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CompositeSwitchInfo]): CompositeSwitchInfo =
    {
        val parent = AssetInfoSerializer.read(kryo, input, classOf[AssetInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = CompositeSwitchInfo(
            parent,
            if (isSet(0)) input.readBoolean else false,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) input.readString else null,
            if (isSet(5)) input.readInt else 0,
            if (isSet(6)) input.readDouble else 0.0,
            if (isSet(7)) input.readBoolean else false,
            if (isSet(8)) input.readInt else 0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Properties of current transformer asset.
 *
 * @param AssetInfo          [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param accuracyClass      CT accuracy classification.
 * @param accuracyLimit      Accuracy limit.
 * @param coreCount          Number of cores.
 * @param ctClass            <em>undocumented</em>
 * @param kneePointCurrent   Maximum primary current where the CT still displays linear characteristicts.
 * @param kneePointVoltage   Maximum voltage across the secondary terminals where the CT still displays linear characteristicts.
 * @param maxRatio           Maximum ratio between the primary and secondary current.
 * @param nominalRatio       Nominal ratio between the primary and secondary current; i.e. 100:5.
 * @param primaryFlsRating   Full load secondary (FLS) rating for primary winding.
 * @param primaryRatio       Ratio for the primary winding tap changer.
 * @param ratedCurrent       Rated current on the primary side.
 * @param secondaryFlsRating Full load secondary (FLS) rating for secondary winding.
 * @param secondaryRatio     Ratio for the secondary winding tap changer.
 * @param tertiaryFlsRating  Full load secondary (FLS) rating for tertiary winding.
 * @param tertiaryRatio      Ratio for the tertiary winding tap changer.
 * @param usage              Usage: eg. metering, protection, etc.
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
final case class CurrentTransformerInfo
(
    AssetInfo: AssetInfo = null,
    accuracyClass: String = null,
    accuracyLimit: Double = 0.0,
    coreCount: Int = 0,
    ctClass: String = null,
    kneePointCurrent: Double = 0.0,
    kneePointVoltage: Double = 0.0,
    maxRatio: String = null,
    nominalRatio: String = null,
    primaryFlsRating: Double = 0.0,
    primaryRatio: String = null,
    ratedCurrent: Double = 0.0,
    secondaryFlsRating: Double = 0.0,
    secondaryRatio: String = null,
    tertiaryFlsRating: Double = 0.0,
    tertiaryRatio: String = null,
    usage: String = null
)
    extends
        Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: AssetInfo = AssetInfo

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = CurrentTransformerInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(CurrentTransformerInfo.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(CurrentTransformerInfo.fields(position), value)

        emitelem(0, accuracyClass)
        emitelem(1, accuracyLimit)
        emitelem(2, coreCount)
        emitelem(3, ctClass)
        emitelem(4, kneePointCurrent)
        emitelem(5, kneePointVoltage)
        emitattr(6, maxRatio)
        emitattr(7, nominalRatio)
        emitelem(8, primaryFlsRating)
        emitattr(9, primaryRatio)
        emitelem(10, ratedCurrent)
        emitelem(11, secondaryFlsRating)
        emitattr(12, secondaryRatio)
        emitelem(13, tertiaryFlsRating)
        emitattr(14, tertiaryRatio)
        emitelem(15, usage)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:CurrentTransformerInfo rdf:%s=\"%s\">\n%s\t</cim:CurrentTransformerInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object CurrentTransformerInfo
    extends
        CIMParseable[CurrentTransformerInfo]
{
    override val fields: Array[String] = Array[String](
        "accuracyClass",
        "accuracyLimit",
        "coreCount",
        "ctClass",
        "kneePointCurrent",
        "kneePointVoltage",
        "maxRatio",
        "nominalRatio",
        "primaryFlsRating",
        "primaryRatio",
        "ratedCurrent",
        "secondaryFlsRating",
        "secondaryRatio",
        "tertiaryFlsRating",
        "tertiaryRatio",
        "usage"
    )
    val accuracyClass: Fielder = parse_element(element(cls, fields(0)))
    val accuracyLimit: Fielder = parse_element(element(cls, fields(1)))
    val coreCount: Fielder = parse_element(element(cls, fields(2)))
    val ctClass: Fielder = parse_element(element(cls, fields(3)))
    val kneePointCurrent: Fielder = parse_element(element(cls, fields(4)))
    val kneePointVoltage: Fielder = parse_element(element(cls, fields(5)))
    val maxRatio: Fielder = parse_attribute(attribute(cls, fields(6)))
    val nominalRatio: Fielder = parse_attribute(attribute(cls, fields(7)))
    val primaryFlsRating: Fielder = parse_element(element(cls, fields(8)))
    val primaryRatio: Fielder = parse_attribute(attribute(cls, fields(9)))
    val ratedCurrent: Fielder = parse_element(element(cls, fields(10)))
    val secondaryFlsRating: Fielder = parse_element(element(cls, fields(11)))
    val secondaryRatio: Fielder = parse_attribute(attribute(cls, fields(12)))
    val tertiaryFlsRating: Fielder = parse_element(element(cls, fields(13)))
    val tertiaryRatio: Fielder = parse_attribute(attribute(cls, fields(14)))
    val usage: Fielder = parse_element(element(cls, fields(15)))

    def parse (context: CIMContext): CurrentTransformerInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CurrentTransformerInfo(
            AssetInfo.parse(context),
            mask(accuracyClass(), 0),
            toDouble(mask(accuracyLimit(), 1)),
            toInteger(mask(coreCount(), 2)),
            mask(ctClass(), 3),
            toDouble(mask(kneePointCurrent(), 4)),
            toDouble(mask(kneePointVoltage(), 5)),
            mask(maxRatio(), 6),
            mask(nominalRatio(), 7),
            toDouble(mask(primaryFlsRating(), 8)),
            mask(primaryRatio(), 9),
            toDouble(mask(ratedCurrent(), 10)),
            toDouble(mask(secondaryFlsRating(), 11)),
            mask(secondaryRatio(), 12),
            toDouble(mask(tertiaryFlsRating(), 13)),
            mask(tertiaryRatio(), 14),
            mask(usage(), 15)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CurrentTransformerInfo] = CurrentTransformerInfoSerializer
}

object CurrentTransformerInfoSerializer extends CIMSerializer[CurrentTransformerInfo]
{
    def write (kryo: Kryo, output: Output, obj: CurrentTransformerInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.accuracyClass),
            () => output.writeDouble(obj.accuracyLimit),
            () => output.writeInt(obj.coreCount),
            () => output.writeString(obj.ctClass),
            () => output.writeDouble(obj.kneePointCurrent),
            () => output.writeDouble(obj.kneePointVoltage),
            () => output.writeString(obj.maxRatio),
            () => output.writeString(obj.nominalRatio),
            () => output.writeDouble(obj.primaryFlsRating),
            () => output.writeString(obj.primaryRatio),
            () => output.writeDouble(obj.ratedCurrent),
            () => output.writeDouble(obj.secondaryFlsRating),
            () => output.writeString(obj.secondaryRatio),
            () => output.writeDouble(obj.tertiaryFlsRating),
            () => output.writeString(obj.tertiaryRatio),
            () => output.writeString(obj.usage)
        )
        AssetInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CurrentTransformerInfo]): CurrentTransformerInfo =
    {
        val parent = AssetInfoSerializer.read(kryo, input, classOf[AssetInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = CurrentTransformerInfo(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readInt else 0,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readDouble else 0.0,
            if (isSet(6)) input.readString else null,
            if (isSet(7)) input.readString else null,
            if (isSet(8)) input.readDouble else 0.0,
            if (isSet(9)) input.readString else null,
            if (isSet(10)) input.readDouble else 0.0,
            if (isSet(11)) input.readDouble else 0.0,
            if (isSet(12)) input.readString else null,
            if (isSet(13)) input.readDouble else 0.0,
            if (isSet(14)) input.readString else null,
            if (isSet(15)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Parameters of fault indicator asset.
 *
 * @param AssetInfo [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param resetKind Kind of reset mechanisim of this fault indicator.
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
final case class FaultIndicatorInfo
(
    AssetInfo: AssetInfo = null,
    resetKind: String = null
)
    extends
        Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: AssetInfo = AssetInfo

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = FaultIndicatorInfo.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(FaultIndicatorInfo.fields(position), value)

        emitattr(0, resetKind)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:FaultIndicatorInfo rdf:%s=\"%s\">\n%s\t</cim:FaultIndicatorInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object FaultIndicatorInfo
    extends
        CIMParseable[FaultIndicatorInfo]
{
    override val fields: Array[String] = Array[String](
        "resetKind"
    )
    val resetKind: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): FaultIndicatorInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FaultIndicatorInfo(
            AssetInfo.parse(context),
            mask(resetKind(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[FaultIndicatorInfo] = FaultIndicatorInfoSerializer
}

object FaultIndicatorInfoSerializer extends CIMSerializer[FaultIndicatorInfo]
{
    def write (kryo: Kryo, output: Output, obj: FaultIndicatorInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.resetKind)
        )
        AssetInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FaultIndicatorInfo]): FaultIndicatorInfo =
    {
        val parent = AssetInfoSerializer.read(kryo, input, classOf[AssetInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = FaultIndicatorInfo(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Properties of switch assets.
 *
 * @param SwitchInfo         [[ch.ninecode.model.SwitchInfo SwitchInfo]] Reference to the superclass object.
 * @param dielectricStrength The maximum rms voltage that may be applied across an open contact without breaking down the dielectric properties of the switch in the open position.
 * @param loadBreak          True if switch has load breaking capabiity.
 *                           Unless specified false, this is always assumed to be true for breakers and reclosers.
 * @param makingCapacity     The highest value of current the switch can make at the rated voltage under specified operating conditions without suffering significant deterioration of its performance.
 * @param minimumCurrent     The lowest value of current that the switch can make, carry and break in uninterrupted duty at the rated voltage under specified operating conditions without suffering significant deterioration of its performance.
 * @param poleCount          Number of poles (i.e. of current carrying conductors that are switched).
 * @param remote             True if device is capable of being operated by remote control.
 * @param withstandCurrent   The highest value of current the switch can carry in the closed position at the rated voltage under specified operating conditions without suffering significant deterioration of its performance.
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
final case class OldSwitchInfo
(
    SwitchInfo: SwitchInfo = null,
    dielectricStrength: Double = 0.0,
    loadBreak: Boolean = false,
    makingCapacity: Double = 0.0,
    minimumCurrent: Double = 0.0,
    poleCount: Int = 0,
    remote: Boolean = false,
    withstandCurrent: Double = 0.0
)
    extends
        Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: SwitchInfo = SwitchInfo

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = OldSwitchInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(OldSwitchInfo.fields(position), value)

        emitelem(0, dielectricStrength)
        emitelem(1, loadBreak)
        emitelem(2, makingCapacity)
        emitelem(3, minimumCurrent)
        emitelem(4, poleCount)
        emitelem(5, remote)
        emitelem(6, withstandCurrent)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OldSwitchInfo rdf:%s=\"%s\">\n%s\t</cim:OldSwitchInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OldSwitchInfo
    extends
        CIMParseable[OldSwitchInfo]
{
    override val fields: Array[String] = Array[String](
        "dielectricStrength",
        "loadBreak",
        "makingCapacity",
        "minimumCurrent",
        "poleCount",
        "remote",
        "withstandCurrent"
    )
    val dielectricStrength: Fielder = parse_element(element(cls, fields(0)))
    val loadBreak: Fielder = parse_element(element(cls, fields(1)))
    val makingCapacity: Fielder = parse_element(element(cls, fields(2)))
    val minimumCurrent: Fielder = parse_element(element(cls, fields(3)))
    val poleCount: Fielder = parse_element(element(cls, fields(4)))
    val remote: Fielder = parse_element(element(cls, fields(5)))
    val withstandCurrent: Fielder = parse_element(element(cls, fields(6)))

    def parse (context: CIMContext): OldSwitchInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OldSwitchInfo(
            SwitchInfo.parse(context),
            toDouble(mask(dielectricStrength(), 0)),
            toBoolean(mask(loadBreak(), 1)),
            toDouble(mask(makingCapacity(), 2)),
            toDouble(mask(minimumCurrent(), 3)),
            toInteger(mask(poleCount(), 4)),
            toBoolean(mask(remote(), 5)),
            toDouble(mask(withstandCurrent(), 6))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OldSwitchInfo] = OldSwitchInfoSerializer
}

object OldSwitchInfoSerializer extends CIMSerializer[OldSwitchInfo]
{
    def write (kryo: Kryo, output: Output, obj: OldSwitchInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.dielectricStrength),
            () => output.writeBoolean(obj.loadBreak),
            () => output.writeDouble(obj.makingCapacity),
            () => output.writeDouble(obj.minimumCurrent),
            () => output.writeInt(obj.poleCount),
            () => output.writeBoolean(obj.remote),
            () => output.writeDouble(obj.withstandCurrent)
        )
        SwitchInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OldSwitchInfo]): OldSwitchInfo =
    {
        val parent = SwitchInfoSerializer.read(kryo, input, classOf[SwitchInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OldSwitchInfo(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readBoolean else false,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readInt else 0,
            if (isSet(5)) input.readBoolean else false,
            if (isSet(6)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
final case class OldTransformerEndInfo
(
    TransformerEndInfo: TransformerEndInfo = null,
    dayOverLoadRating: Double = 0.0,
    hourOverLoadRating: Double = 0.0,
    solidInsulationWeight: Double = 0.0,
    windingInsulationKind: String = null
)
    extends
        Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: TransformerEndInfo = TransformerEndInfo

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = OldTransformerEndInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(OldTransformerEndInfo.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(OldTransformerEndInfo.fields(position), value)

        emitelem(0, dayOverLoadRating)
        emitelem(1, hourOverLoadRating)
        emitelem(2, solidInsulationWeight)
        emitattr(3, windingInsulationKind)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OldTransformerEndInfo rdf:%s=\"%s\">\n%s\t</cim:OldTransformerEndInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OldTransformerEndInfo
    extends
        CIMParseable[OldTransformerEndInfo]
{
    override val fields: Array[String] = Array[String](
        "dayOverLoadRating",
        "hourOverLoadRating",
        "solidInsulationWeight",
        "windingInsulationKind"
    )
    val dayOverLoadRating: Fielder = parse_element(element(cls, fields(0)))
    val hourOverLoadRating: Fielder = parse_element(element(cls, fields(1)))
    val solidInsulationWeight: Fielder = parse_element(element(cls, fields(2)))
    val windingInsulationKind: Fielder = parse_attribute(attribute(cls, fields(3)))

    def parse (context: CIMContext): OldTransformerEndInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OldTransformerEndInfo(
            TransformerEndInfo.parse(context),
            toDouble(mask(dayOverLoadRating(), 0)),
            toDouble(mask(hourOverLoadRating(), 1)),
            toDouble(mask(solidInsulationWeight(), 2)),
            mask(windingInsulationKind(), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OldTransformerEndInfo] = OldTransformerEndInfoSerializer
}

object OldTransformerEndInfoSerializer extends CIMSerializer[OldTransformerEndInfo]
{
    def write (kryo: Kryo, output: Output, obj: OldTransformerEndInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.dayOverLoadRating),
            () => output.writeDouble(obj.hourOverLoadRating),
            () => output.writeDouble(obj.solidInsulationWeight),
            () => output.writeString(obj.windingInsulationKind)
        )
        TransformerEndInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OldTransformerEndInfo]): OldTransformerEndInfo =
    {
        val parent = TransformerEndInfoSerializer.read(kryo, input, classOf[TransformerEndInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OldTransformerEndInfo(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
final case class OldTransformerTankInfo
(
    TransformerTankInfo: TransformerTankInfo = null,
    constructionKind: String = null,
    coreCoilsWeight: Double = 0.0,
    coreKind: String = null,
    function: String = null,
    neutralBIL: Double = 0.0,
    oilPreservationKind: String = null
)
    extends
        Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: TransformerTankInfo = TransformerTankInfo

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = OldTransformerTankInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(OldTransformerTankInfo.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(OldTransformerTankInfo.fields(position), value)

        emitattr(0, constructionKind)
        emitelem(1, coreCoilsWeight)
        emitattr(2, coreKind)
        emitattr(3, function)
        emitelem(4, neutralBIL)
        emitattr(5, oilPreservationKind)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OldTransformerTankInfo rdf:%s=\"%s\">\n%s\t</cim:OldTransformerTankInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OldTransformerTankInfo
    extends
        CIMParseable[OldTransformerTankInfo]
{
    override val fields: Array[String] = Array[String](
        "constructionKind",
        "coreCoilsWeight",
        "coreKind",
        "function",
        "neutralBIL",
        "oilPreservationKind"
    )
    val constructionKind: Fielder = parse_attribute(attribute(cls, fields(0)))
    val coreCoilsWeight: Fielder = parse_element(element(cls, fields(1)))
    val coreKind: Fielder = parse_attribute(attribute(cls, fields(2)))
    val function: Fielder = parse_attribute(attribute(cls, fields(3)))
    val neutralBIL: Fielder = parse_element(element(cls, fields(4)))
    val oilPreservationKind: Fielder = parse_attribute(attribute(cls, fields(5)))

    def parse (context: CIMContext): OldTransformerTankInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OldTransformerTankInfo(
            TransformerTankInfo.parse(context),
            mask(constructionKind(), 0),
            toDouble(mask(coreCoilsWeight(), 1)),
            mask(coreKind(), 2),
            mask(function(), 3),
            toDouble(mask(neutralBIL(), 4)),
            mask(oilPreservationKind(), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OldTransformerTankInfo] = OldTransformerTankInfoSerializer
}

object OldTransformerTankInfoSerializer extends CIMSerializer[OldTransformerTankInfo]
{
    def write (kryo: Kryo, output: Output, obj: OldTransformerTankInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.constructionKind),
            () => output.writeDouble(obj.coreCoilsWeight),
            () => output.writeString(obj.coreKind),
            () => output.writeString(obj.function),
            () => output.writeDouble(obj.neutralBIL),
            () => output.writeString(obj.oilPreservationKind)
        )
        TransformerTankInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OldTransformerTankInfo]): OldTransformerTankInfo =
    {
        val parent = TransformerTankInfoSerializer.read(kryo, input, classOf[TransformerTankInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OldTransformerTankInfo(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Properties of potential transformer asset.
 *
 * @param AssetInfo      [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param accuracyClass  <em>undocumented</em>
 * @param nominalRatio   <em>undocumented</em>
 * @param primaryRatio   Ratio for the primary winding tap changer.
 * @param ptClass        <em>undocumented</em>
 * @param ratedVoltage   Rated voltage on the primary side.
 * @param secondaryRatio Ratio for the secondary winding tap changer.
 * @param tertiaryRatio  Ratio for the tertiary winding tap changer.
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
final case class PotentialTransformerInfo
(
    AssetInfo: AssetInfo = null,
    accuracyClass: String = null,
    nominalRatio: String = null,
    primaryRatio: String = null,
    ptClass: String = null,
    ratedVoltage: Double = 0.0,
    secondaryRatio: String = null,
    tertiaryRatio: String = null
)
    extends
        Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: AssetInfo = AssetInfo

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = PotentialTransformerInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(PotentialTransformerInfo.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(PotentialTransformerInfo.fields(position), value)

        emitelem(0, accuracyClass)
        emitattr(1, nominalRatio)
        emitattr(2, primaryRatio)
        emitelem(3, ptClass)
        emitelem(4, ratedVoltage)
        emitattr(5, secondaryRatio)
        emitattr(6, tertiaryRatio)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PotentialTransformerInfo rdf:%s=\"%s\">\n%s\t</cim:PotentialTransformerInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object PotentialTransformerInfo
    extends
        CIMParseable[PotentialTransformerInfo]
{
    override val fields: Array[String] = Array[String](
        "accuracyClass",
        "nominalRatio",
        "primaryRatio",
        "ptClass",
        "ratedVoltage",
        "secondaryRatio",
        "tertiaryRatio"
    )
    val accuracyClass: Fielder = parse_element(element(cls, fields(0)))
    val nominalRatio: Fielder = parse_attribute(attribute(cls, fields(1)))
    val primaryRatio: Fielder = parse_attribute(attribute(cls, fields(2)))
    val ptClass: Fielder = parse_element(element(cls, fields(3)))
    val ratedVoltage: Fielder = parse_element(element(cls, fields(4)))
    val secondaryRatio: Fielder = parse_attribute(attribute(cls, fields(5)))
    val tertiaryRatio: Fielder = parse_attribute(attribute(cls, fields(6)))

    def parse (context: CIMContext): PotentialTransformerInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PotentialTransformerInfo(
            AssetInfo.parse(context),
            mask(accuracyClass(), 0),
            mask(nominalRatio(), 1),
            mask(primaryRatio(), 2),
            mask(ptClass(), 3),
            toDouble(mask(ratedVoltage(), 4)),
            mask(secondaryRatio(), 5),
            mask(tertiaryRatio(), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PotentialTransformerInfo] = PotentialTransformerInfoSerializer
}

object PotentialTransformerInfoSerializer extends CIMSerializer[PotentialTransformerInfo]
{
    def write (kryo: Kryo, output: Output, obj: PotentialTransformerInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.accuracyClass),
            () => output.writeString(obj.nominalRatio),
            () => output.writeString(obj.primaryRatio),
            () => output.writeString(obj.ptClass),
            () => output.writeDouble(obj.ratedVoltage),
            () => output.writeString(obj.secondaryRatio),
            () => output.writeString(obj.tertiaryRatio)
        )
        AssetInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PotentialTransformerInfo]): PotentialTransformerInfo =
    {
        val parent = AssetInfoSerializer.read(kryo, input, classOf[AssetInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = PotentialTransformerInfo(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readString else null,
            if (isSet(6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Properties of protection equipment asset.
 *
 * @param AssetInfo  [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param groundTrip Actual ground trip for this type of relay, if applicable.
 * @param phaseTrip  Actual phase trip for this type of relay, if applicable.
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
final case class ProtectionEquipmentInfo
(
    AssetInfo: AssetInfo = null,
    groundTrip: Double = 0.0,
    phaseTrip: Double = 0.0
)
    extends
        Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: AssetInfo = AssetInfo

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ProtectionEquipmentInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(ProtectionEquipmentInfo.fields(position), value)

        emitelem(0, groundTrip)
        emitelem(1, phaseTrip)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ProtectionEquipmentInfo rdf:%s=\"%s\">\n%s\t</cim:ProtectionEquipmentInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ProtectionEquipmentInfo
    extends
        CIMParseable[ProtectionEquipmentInfo]
{
    override val fields: Array[String] = Array[String](
        "groundTrip",
        "phaseTrip"
    )
    val groundTrip: Fielder = parse_element(element(cls, fields(0)))
    val phaseTrip: Fielder = parse_element(element(cls, fields(1)))

    def parse (context: CIMContext): ProtectionEquipmentInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ProtectionEquipmentInfo(
            AssetInfo.parse(context),
            toDouble(mask(groundTrip(), 0)),
            toDouble(mask(phaseTrip(), 1))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ProtectionEquipmentInfo] = ProtectionEquipmentInfoSerializer
}

object ProtectionEquipmentInfoSerializer extends CIMSerializer[ProtectionEquipmentInfo]
{
    def write (kryo: Kryo, output: Output, obj: ProtectionEquipmentInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.groundTrip),
            () => output.writeDouble(obj.phaseTrip)
        )
        AssetInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ProtectionEquipmentInfo]): ProtectionEquipmentInfo =
    {
        val parent = AssetInfoSerializer.read(kryo, input, classOf[AssetInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ProtectionEquipmentInfo(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Properties of recloser assets.
 *
 * @param OldSwitchInfo           [[ch.ninecode.model.OldSwitchInfo OldSwitchInfo]] Reference to the superclass object.
 * @param groundTripCapable       True if device has ground trip capability.
 * @param groundTripNormalEnabled True if normal status of ground trip is enabled.
 * @param groundTripRating        Ground trip rating.
 * @param phaseTripRating         Phase trip rating.
 * @param recloseLockoutCount     Total number of phase reclose operations.
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
final case class RecloserInfo
(
    OldSwitchInfo: OldSwitchInfo = null,
    groundTripCapable: Boolean = false,
    groundTripNormalEnabled: Boolean = false,
    groundTripRating: Double = 0.0,
    phaseTripRating: Double = 0.0,
    recloseLockoutCount: Int = 0
)
    extends
        Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: OldSwitchInfo = OldSwitchInfo

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = RecloserInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(RecloserInfo.fields(position), value)

        emitelem(0, groundTripCapable)
        emitelem(1, groundTripNormalEnabled)
        emitelem(2, groundTripRating)
        emitelem(3, phaseTripRating)
        emitelem(4, recloseLockoutCount)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:RecloserInfo rdf:%s=\"%s\">\n%s\t</cim:RecloserInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object RecloserInfo
    extends
        CIMParseable[RecloserInfo]
{
    override val fields: Array[String] = Array[String](
        "groundTripCapable",
        "groundTripNormalEnabled",
        "groundTripRating",
        "phaseTripRating",
        "recloseLockoutCount"
    )
    val groundTripCapable: Fielder = parse_element(element(cls, fields(0)))
    val groundTripNormalEnabled: Fielder = parse_element(element(cls, fields(1)))
    val groundTripRating: Fielder = parse_element(element(cls, fields(2)))
    val phaseTripRating: Fielder = parse_element(element(cls, fields(3)))
    val recloseLockoutCount: Fielder = parse_element(element(cls, fields(4)))

    def parse (context: CIMContext): RecloserInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RecloserInfo(
            OldSwitchInfo.parse(context),
            toBoolean(mask(groundTripCapable(), 0)),
            toBoolean(mask(groundTripNormalEnabled(), 1)),
            toDouble(mask(groundTripRating(), 2)),
            toDouble(mask(phaseTripRating(), 3)),
            toInteger(mask(recloseLockoutCount(), 4))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[RecloserInfo] = RecloserInfoSerializer
}

object RecloserInfoSerializer extends CIMSerializer[RecloserInfo]
{
    def write (kryo: Kryo, output: Output, obj: RecloserInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeBoolean(obj.groundTripCapable),
            () => output.writeBoolean(obj.groundTripNormalEnabled),
            () => output.writeDouble(obj.groundTripRating),
            () => output.writeDouble(obj.phaseTripRating),
            () => output.writeInt(obj.recloseLockoutCount)
        )
        OldSwitchInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RecloserInfo]): RecloserInfo =
    {
        val parent = OldSwitchInfoSerializer.read(kryo, input, classOf[OldSwitchInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = RecloserInfo(
            parent,
            if (isSet(0)) input.readBoolean else false,
            if (isSet(1)) input.readBoolean else false,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readInt else 0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Properties of surge arrester.
 *
 * @param AssetInfo                        [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param continuousOperatingVoltage       Maximum continuous power frequency voltage allowed on the surge arrester.
 * @param isPolymer                        If true, the arrester has a polymer housing, porcelain otherwise.
 * @param lightningImpulseDischargeVoltage Residual voltage during an 8x20 microsecond current impulse at the nominal discharge current level.
 * @param lineDischargeClass               Determines the arrester energy discharge capability.
 *                                         Choices are limited to 0 (none) through 5 (highest) by IEC 60099. Classes 1..3 require a 10-kA nominal discharge current. Classes 4..5 require a 20-kA nominal discharge current. Lower nominal discharge currents must use class 0.
 * @param nominalDischargeCurrent          The lightning discharge current used to classify the arrester.
 *                                         Choices are limited to 1.5, 2.5, 5, 10, and 20 kA by IEC 60099.
 * @param pressureReliefClass              Fault current level at which all parts of the failed arrester lie within a circle prescribed by IEC 60099.
 * @param ratedVoltage                     The temporary overvoltage (TOV) level at power frequency that the surge arrester withstands for 10 seconds.
 * @param steepFrontDischargeVoltage       Residual voltage during a current impulse with front time of 1 microsecond, and magnitude equal to the nominal discharge current level.
 * @param switchingImpulseDischargeVoltage Residual voltage during a current impulse with front time of at least 30 microseconds, and magnitude specified in IEC 60099 for the line discharge class.
 *                                         Does not apply to line discharge class 0.
 * @group InfAssetInfo
 * @groupname InfAssetInfo Package InfAssetInfo
 */
final case class SurgeArresterInfo
(
    AssetInfo: AssetInfo = null,
    continuousOperatingVoltage: Double = 0.0,
    isPolymer: Boolean = false,
    lightningImpulseDischargeVoltage: Double = 0.0,
    lineDischargeClass: Int = 0,
    nominalDischargeCurrent: Double = 0.0,
    pressureReliefClass: Double = 0.0,
    ratedVoltage: Double = 0.0,
    steepFrontDischargeVoltage: Double = 0.0,
    switchingImpulseDischargeVoltage: Double = 0.0
)
    extends
        Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: AssetInfo = AssetInfo

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = SurgeArresterInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(SurgeArresterInfo.fields(position), value)

        emitelem(0, continuousOperatingVoltage)
        emitelem(1, isPolymer)
        emitelem(2, lightningImpulseDischargeVoltage)
        emitelem(3, lineDischargeClass)
        emitelem(4, nominalDischargeCurrent)
        emitelem(5, pressureReliefClass)
        emitelem(6, ratedVoltage)
        emitelem(7, steepFrontDischargeVoltage)
        emitelem(8, switchingImpulseDischargeVoltage)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:SurgeArresterInfo rdf:%s=\"%s\">\n%s\t</cim:SurgeArresterInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object SurgeArresterInfo
    extends
        CIMParseable[SurgeArresterInfo]
{
    override val fields: Array[String] = Array[String](
        "continuousOperatingVoltage",
        "isPolymer",
        "lightningImpulseDischargeVoltage",
        "lineDischargeClass",
        "nominalDischargeCurrent",
        "pressureReliefClass",
        "ratedVoltage",
        "steepFrontDischargeVoltage",
        "switchingImpulseDischargeVoltage"
    )
    val continuousOperatingVoltage: Fielder = parse_element(element(cls, fields(0)))
    val isPolymer: Fielder = parse_element(element(cls, fields(1)))
    val lightningImpulseDischargeVoltage: Fielder = parse_element(element(cls, fields(2)))
    val lineDischargeClass: Fielder = parse_element(element(cls, fields(3)))
    val nominalDischargeCurrent: Fielder = parse_element(element(cls, fields(4)))
    val pressureReliefClass: Fielder = parse_element(element(cls, fields(5)))
    val ratedVoltage: Fielder = parse_element(element(cls, fields(6)))
    val steepFrontDischargeVoltage: Fielder = parse_element(element(cls, fields(7)))
    val switchingImpulseDischargeVoltage: Fielder = parse_element(element(cls, fields(8)))

    def parse (context: CIMContext): SurgeArresterInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SurgeArresterInfo(
            AssetInfo.parse(context),
            toDouble(mask(continuousOperatingVoltage(), 0)),
            toBoolean(mask(isPolymer(), 1)),
            toDouble(mask(lightningImpulseDischargeVoltage(), 2)),
            toInteger(mask(lineDischargeClass(), 3)),
            toDouble(mask(nominalDischargeCurrent(), 4)),
            toDouble(mask(pressureReliefClass(), 5)),
            toDouble(mask(ratedVoltage(), 6)),
            toDouble(mask(steepFrontDischargeVoltage(), 7)),
            toDouble(mask(switchingImpulseDischargeVoltage(), 8))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SurgeArresterInfo] = SurgeArresterInfoSerializer
}

object SurgeArresterInfoSerializer extends CIMSerializer[SurgeArresterInfo]
{
    def write (kryo: Kryo, output: Output, obj: SurgeArresterInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.continuousOperatingVoltage),
            () => output.writeBoolean(obj.isPolymer),
            () => output.writeDouble(obj.lightningImpulseDischargeVoltage),
            () => output.writeInt(obj.lineDischargeClass),
            () => output.writeDouble(obj.nominalDischargeCurrent),
            () => output.writeDouble(obj.pressureReliefClass),
            () => output.writeDouble(obj.ratedVoltage),
            () => output.writeDouble(obj.steepFrontDischargeVoltage),
            () => output.writeDouble(obj.switchingImpulseDischargeVoltage)
        )
        AssetInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SurgeArresterInfo]): SurgeArresterInfo =
    {
        val parent = AssetInfoSerializer.read(kryo, input, classOf[AssetInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = SurgeArresterInfo(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readBoolean else false,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readInt else 0,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readDouble else 0.0,
            if (isSet(6)) input.readDouble else 0.0,
            if (isSet(7)) input.readDouble else 0.0,
            if (isSet(8)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _InfAssetInfo
{
    def register: List[CIMClassInfo] =
    {
        List(
            AssetModelCatalogue.register,
            AssetModelCatalogueItem.register,
            BreakerInfo.register,
            CompositeSwitchInfo.register,
            CurrentTransformerInfo.register,
            FaultIndicatorInfo.register,
            OldSwitchInfo.register,
            OldTransformerEndInfo.register,
            OldTransformerTankInfo.register,
            PotentialTransformerInfo.register,
            ProtectionEquipmentInfo.register,
            RecloserInfo.register,
            SurgeArresterInfo.register
        )
    }
}