package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable


/**
 * Information about a particular piece of (land) property such as its use.
 * Ownership of the property may be determined through associations to Organisations and/or ErpPersons.
 * @param sup Reference to the superclass object.
 * @param demographicKind Demographics around the site.
 * @param externalRecordReference Reference allocated by the governing organisation (such as municipality) to this piece of land that has a formal reference to Surveyor General's records.
 *        The governing organisation is specified in associated Organisation.
 * @param kind Kind of (land) property, categorised according to its main functional use from the utility's perspective.
 * @param status <em>undocumented</em>
 * @param AssetContainers <em>undocumented</em>
 * @param Locations The spatail description of a piece of property.
 */
case class LandProperty
(
    override val sup: IdentifiedObject,
    demographicKind: String,
    externalRecordReference: String,
    kind: String,
    status: String,
    AssetContainers: List[String],
    Locations: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, List(), List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[LandProperty] }
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
        sup.export_fields +
        (if (null != demographicKind) "\t\t<cim:LandProperty.demographicKind rdf:resource=\"#" + demographicKind + "\"/>\n" else "") +
        (if (null != externalRecordReference) "\t\t<cim:LandProperty.externalRecordReference>" + externalRecordReference + "</cim:LandProperty.externalRecordReference>\n" else "") +
        (if (null != kind) "\t\t<cim:LandProperty.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != status) "\t\t<cim:LandProperty.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != AssetContainers) AssetContainers.map (x => "\t\t<cim:LandProperty.AssetContainers rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Locations) Locations.map (x => "\t\t<cim:LandProperty.Locations rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:LandProperty rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LandProperty>"
    }
}

object LandProperty
extends
    Parseable[LandProperty]
{
    val demographicKind: (Context) => String = parse_attribute (attribute ("""LandProperty.demographicKind"""))
    val externalRecordReference: (Context) => String = parse_element (element ("""LandProperty.externalRecordReference"""))
    val kind: (Context) => String = parse_attribute (attribute ("""LandProperty.kind"""))
    val status: (Context) => String = parse_attribute (attribute ("""LandProperty.status"""))
    val AssetContainers: (Context) => List[String] = parse_attributes (attribute ("""LandProperty.AssetContainers"""))
    val Locations: (Context) => List[String] = parse_attributes (attribute ("""LandProperty.Locations"""))
    def parse (context: Context): LandProperty =
    {
        LandProperty(
            IdentifiedObject.parse (context),
            demographicKind (context),
            externalRecordReference (context),
            kind (context),
            status (context),
            AssetContainers (context),
            Locations (context)
        )
    }
}

/**
 * A grant provides a right, as defined by type, for a parcel of land.
 * Note that the association to Location, Asset, Organisation, etc. for the Grant is inherited from Agreement, a type of Document.
 * @param sup Reference to the superclass object.
 * @param propertyData Property related information that describes the Grant's land parcel.
 *        For example, it may be a deed book number, deed book page number, and parcel number.
 * @param LandProperty Land property this location grant applies to.
 */
case class LocationGrant
(
    override val sup: Agreement,
    propertyData: String,
    LandProperty: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { clone ().asInstanceOf[LocationGrant] }
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
        sup.export_fields +
        (if (null != propertyData) "\t\t<cim:LocationGrant.propertyData>" + propertyData + "</cim:LocationGrant.propertyData>\n" else "") +
        (if (null != LandProperty) "\t\t<cim:LocationGrant.LandProperty rdf:resource=\"#" + LandProperty + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LocationGrant rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LocationGrant>"
    }
}

object LocationGrant
extends
    Parseable[LocationGrant]
{
    val propertyData: (Context) => String = parse_element (element ("""LocationGrant.propertyData"""))
    val LandProperty: (Context) => String = parse_attribute (attribute ("""LocationGrant.LandProperty"""))
    def parse (context: Context): LocationGrant =
    {
        LocationGrant(
            Agreement.parse (context),
            propertyData (context),
            LandProperty (context)
        )
    }
}

/**
 * This class is used for handling the accompanying annotations, time stamp, author, etc. of designs, drawings and maps.
 * A red line can be associated with any Location object.
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 */
case class RedLine
(
    override val sup: IdentifiedObject,
    status: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[RedLine] }
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
        sup.export_fields +
        (if (null != status) "\t\t<cim:RedLine.status rdf:resource=\"#" + status + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RedLine rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RedLine>"
    }
}

object RedLine
extends
    Parseable[RedLine]
{
    val status: (Context) => String = parse_attribute (attribute ("""RedLine.status"""))
    def parse (context: Context): RedLine =
    {
        RedLine(
            IdentifiedObject.parse (context),
            status (context)
        )
    }
}

/**
 * A right-of-way (ROW) is for land where it is lawful to use for a public road, an electric power line, etc.
 * Note that the association to Location, Asset, Organisation, etc. for the Grant is inherited from Agreement, a type of Document.
 * @param sup Reference to the superclass object.
 * @param propertyData Property related information that describes the ROW's land parcel.
 *        For example, it may be a deed book number, deed book page number, and parcel number.
 * @param LandProperties All land properties this right of way applies to.
 */
case class RightOfWay
(
    override val sup: Agreement,
    propertyData: String,
    LandProperties: List[String]
)
extends
    Element
{
    def this () = { this (null, null, List()) }
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { clone ().asInstanceOf[RightOfWay] }
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
        sup.export_fields +
        (if (null != propertyData) "\t\t<cim:RightOfWay.propertyData>" + propertyData + "</cim:RightOfWay.propertyData>\n" else "") +
        (if (null != LandProperties) LandProperties.map (x => "\t\t<cim:RightOfWay.LandProperties rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:RightOfWay rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RightOfWay>"
    }
}

object RightOfWay
extends
    Parseable[RightOfWay]
{
    val propertyData: (Context) => String = parse_element (element ("""RightOfWay.propertyData"""))
    val LandProperties: (Context) => List[String] = parse_attributes (attribute ("""RightOfWay.LandProperties"""))
    def parse (context: Context): RightOfWay =
    {
        RightOfWay(
            Agreement.parse (context),
            propertyData (context),
            LandProperties (context)
        )
    }
}

/**
 * Route that is followed, for example by service crews.
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param typ Classification by utility's work management standards and practices.
 * @param Locations <em>undocumented</em>
 */
case class Route
(
    override val sup: IdentifiedObject,
    status: String,
    typ: String,
    Locations: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Route] }
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
        sup.export_fields +
        (if (null != status) "\t\t<cim:Route.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != typ) "\t\t<cim:Route.type>" + typ + "</cim:Route.type>\n" else "") +
        (if (null != Locations) Locations.map (x => "\t\t<cim:Route.Locations rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Route rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Route>"
    }
}

object Route
extends
    Parseable[Route]
{
    val status: (Context) => String = parse_attribute (attribute ("""Route.status"""))
    val typ: (Context) => String = parse_element (element ("""Route.type"""))
    val Locations: (Context) => List[String] = parse_attributes (attribute ("""Route.Locations"""))
    def parse (context: Context): Route =
    {
        Route(
            IdentifiedObject.parse (context),
            status (context),
            typ (context),
            Locations (context)
        )
    }
}

/**
 * Area divided off from other areas.
 * It may be part of the electrical network, a land area where special restrictions apply, weather areas, etc. For weather, it is an area where a set of relatively homogenous weather measurements apply.
 * @param sup Reference to the superclass object.
 * @param kind Kind of this zone.
 */
case class Zone
(
    override val sup: Location,
    kind: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Location: Location = sup.asInstanceOf[Location]
    override def copy (): Row = { clone ().asInstanceOf[Zone] }
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
        sup.export_fields +
        (if (null != kind) "\t\t<cim:Zone.kind rdf:resource=\"#" + kind + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Zone rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Zone>"
    }
}

object Zone
extends
    Parseable[Zone]
{
    val kind: (Context) => String = parse_attribute (attribute ("""Zone.kind"""))
    def parse (context: Context): Zone =
    {
        Zone(
            Location.parse (context),
            kind (context)
        )
    }
}

private[ninecode] object _InfLocations
{
    def register: List[ClassInfo] =
    {
        List (
            LandProperty.register,
            LocationGrant.register,
            RedLine.register,
            RightOfWay.register,
            Route.register,
            Zone.register
        )
    }
}