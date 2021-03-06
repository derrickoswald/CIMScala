package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable

import ch.ninecode.cim.CIMSerializer

/**
 * This is the cureve that describes the load reduction time.
 *
 * Relationship between time (Y1-axis) vs. MW (X-axis).
 *
 * @param Curve                      [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param loadReductionTimeCurveType type of the curve: Possible values are but not limited to:
 *                                   Max, Min,
 * @group InfReferenceData
 * @groupname InfReferenceData Package InfReferenceData
 */
final case class LoadReductionTimeCurve
(
    Curve: Curve = null,
    loadReductionTimeCurveType: String = null
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
    override def sup: Curve = Curve

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
        implicit val clz: String = LoadReductionTimeCurve.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(LoadReductionTimeCurve.fields(position), value)

        emitelem(0, loadReductionTimeCurveType)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:LoadReductionTimeCurve rdf:%s=\"%s\">\n%s\t</cim:LoadReductionTimeCurve>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object LoadReductionTimeCurve
    extends
        CIMParseable[LoadReductionTimeCurve]
{
    override val fields: Array[String] = Array[String](
        "loadReductionTimeCurveType"
    )
    val loadReductionTimeCurveType: Fielder = parse_element(element(cls, fields(0)))

    def parse (context: CIMContext): LoadReductionTimeCurve =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LoadReductionTimeCurve(
            Curve.parse(context),
            mask(loadReductionTimeCurveType(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[LoadReductionTimeCurve] = LoadReductionTimeCurveSerializer
}

object LoadReductionTimeCurveSerializer extends CIMSerializer[LoadReductionTimeCurve]
{
    def write (kryo: Kryo, output: Output, obj: LoadReductionTimeCurve): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.loadReductionTimeCurveType)
        )
        CurveSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LoadReductionTimeCurve]): LoadReductionTimeCurve =
    {
        val parent = CurveSerializer.read(kryo, input, classOf[Curve])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = LoadReductionTimeCurve(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Temporary holding for load reduction attributes removed from RegisteredLoad.
 *
 * Use for future use case when developing the RegisteredDistributedResource specialized classes.
 *
 * @param Element                  Reference to the superclass object.
 * @param maxBaseLoad              Maximum Base Load (MW), per Participating Load Resource
 * @param maxDeploymentTime        Maximum Deployment time (seconds)
 * @param maxLoadRedTimesPerDay    Maximum Number of Daily Load Curtailments
 * @param maxLoadReduction         maximum load reduction
 * @param maxReductionTime         Maxiimum Load Reduction Time (min), per Participating Load Resource
 * @param maxWeeklyDeployment      Maximum weekly deployments
 * @param minLoadReduction         Minimum MW for a load reduction (e.g., MW rating of a discrete pump.
 *                                 This attribute may be used also in the LoadBid class. The reason that the attribute is also modeled in this class is that it is resource attribute and needs to be persistently stored.
 * @param minLoadReductionCost     minimum load reduction cost.
 *                                 Single number for the load
 * @param minLoadReductionInterval Shortest period load reduction shall be maintained before load can be restored to normal levels.
 *                                 This attribute may be used also in the LoadBid class. The reason that the attribute is also modeled in this class is that it is resource attribute and needs to be persistently stored.
 * @param minReductionTime         Minimum Load Reduction Time (min), per Participating Load Resource
 * @param minTimeBetLoadRed        Shortest time that load shall be left at normal levels before a new load reduction.
 *                                 This attribute may be used also in the LoadBid class. The reason that the attribute is also modeled in this class is that it is resource attribute and needs to be persistently stored.
 * @param reqNoticeTime            Time period that is required from an order to reduce a load to the time that it takes to get to the minimum load reduction.
 *                                 This attribute may be used also in the LoadBid class. The reason that the attribute is also modeled in this class is that it is resource attribute and needs to be persistently stored.
 * @group InfReferenceData
 * @groupname InfReferenceData Package InfReferenceData
 */
final case class RegisteredControllableLoad
(
    Element: BasicElement = null,
    maxBaseLoad: Double = 0.0,
    maxDeploymentTime: Double = 0.0,
    maxLoadRedTimesPerDay: Int = 0,
    maxLoadReduction: Double = 0.0,
    maxReductionTime: Double = 0.0,
    maxWeeklyDeployment: Int = 0,
    minLoadReduction: Double = 0.0,
    minLoadReductionCost: Double = 0.0,
    minLoadReductionInterval: Double = 0.0,
    minReductionTime: Double = 0.0,
    minTimeBetLoadRed: Double = 0.0,
    reqNoticeTime: Double = 0.0
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
    override def sup: Element = Element

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
        implicit val clz: String = RegisteredControllableLoad.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(RegisteredControllableLoad.fields(position), value)

        emitelem(0, maxBaseLoad)
        emitelem(1, maxDeploymentTime)
        emitelem(2, maxLoadRedTimesPerDay)
        emitelem(3, maxLoadReduction)
        emitelem(4, maxReductionTime)
        emitelem(5, maxWeeklyDeployment)
        emitelem(6, minLoadReduction)
        emitelem(7, minLoadReductionCost)
        emitelem(8, minLoadReductionInterval)
        emitelem(9, minReductionTime)
        emitelem(10, minTimeBetLoadRed)
        emitelem(11, reqNoticeTime)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:RegisteredControllableLoad rdf:%s=\"%s\">\n%s\t</cim:RegisteredControllableLoad>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object RegisteredControllableLoad
    extends
        CIMParseable[RegisteredControllableLoad]
{
    override val fields: Array[String] = Array[String](
        "maxBaseLoad",
        "maxDeploymentTime",
        "maxLoadRedTimesPerDay",
        "maxLoadReduction",
        "maxReductionTime",
        "maxWeeklyDeployment",
        "minLoadReduction",
        "minLoadReductionCost",
        "minLoadReductionInterval",
        "minReductionTime",
        "minTimeBetLoadRed",
        "reqNoticeTime"
    )
    val maxBaseLoad: Fielder = parse_element(element(cls, fields(0)))
    val maxDeploymentTime: Fielder = parse_element(element(cls, fields(1)))
    val maxLoadRedTimesPerDay: Fielder = parse_element(element(cls, fields(2)))
    val maxLoadReduction: Fielder = parse_element(element(cls, fields(3)))
    val maxReductionTime: Fielder = parse_element(element(cls, fields(4)))
    val maxWeeklyDeployment: Fielder = parse_element(element(cls, fields(5)))
    val minLoadReduction: Fielder = parse_element(element(cls, fields(6)))
    val minLoadReductionCost: Fielder = parse_element(element(cls, fields(7)))
    val minLoadReductionInterval: Fielder = parse_element(element(cls, fields(8)))
    val minReductionTime: Fielder = parse_element(element(cls, fields(9)))
    val minTimeBetLoadRed: Fielder = parse_element(element(cls, fields(10)))
    val reqNoticeTime: Fielder = parse_element(element(cls, fields(11)))

    def parse (context: CIMContext): RegisteredControllableLoad =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RegisteredControllableLoad(
            BasicElement.parse(context),
            toDouble(mask(maxBaseLoad(), 0)),
            toDouble(mask(maxDeploymentTime(), 1)),
            toInteger(mask(maxLoadRedTimesPerDay(), 2)),
            toDouble(mask(maxLoadReduction(), 3)),
            toDouble(mask(maxReductionTime(), 4)),
            toInteger(mask(maxWeeklyDeployment(), 5)),
            toDouble(mask(minLoadReduction(), 6)),
            toDouble(mask(minLoadReductionCost(), 7)),
            toDouble(mask(minLoadReductionInterval(), 8)),
            toDouble(mask(minReductionTime(), 9)),
            toDouble(mask(minTimeBetLoadRed(), 10)),
            toDouble(mask(reqNoticeTime(), 11))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[RegisteredControllableLoad] = RegisteredControllableLoadSerializer
}

object RegisteredControllableLoadSerializer extends CIMSerializer[RegisteredControllableLoad]
{
    def write (kryo: Kryo, output: Output, obj: RegisteredControllableLoad): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.maxBaseLoad),
            () => output.writeDouble(obj.maxDeploymentTime),
            () => output.writeInt(obj.maxLoadRedTimesPerDay),
            () => output.writeDouble(obj.maxLoadReduction),
            () => output.writeDouble(obj.maxReductionTime),
            () => output.writeInt(obj.maxWeeklyDeployment),
            () => output.writeDouble(obj.minLoadReduction),
            () => output.writeDouble(obj.minLoadReductionCost),
            () => output.writeDouble(obj.minLoadReductionInterval),
            () => output.writeDouble(obj.minReductionTime),
            () => output.writeDouble(obj.minTimeBetLoadRed),
            () => output.writeDouble(obj.reqNoticeTime)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RegisteredControllableLoad]): RegisteredControllableLoad =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = RegisteredControllableLoad(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readInt else 0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readInt else 0,
            if (isSet(6)) input.readDouble else 0.0,
            if (isSet(7)) input.readDouble else 0.0,
            if (isSet(8)) input.readDouble else 0.0,
            if (isSet(9)) input.readDouble else 0.0,
            if (isSet(10)) input.readDouble else 0.0,
            if (isSet(11)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _InfReferenceData
{
    def register: List[CIMClassInfo] =
    {
        List(
            LoadReductionTimeCurve.register,
            RegisteredControllableLoad.register
        )
    }
}