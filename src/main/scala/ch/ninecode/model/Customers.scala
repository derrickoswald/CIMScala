package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * This package contains the core information classes that support customer billing applications.
 */

/**
 * Organisation receiving services from service supplier.
 * @param sup Reference to the superclass object.
 * @param kind Kind of customer.
 * @param locale Locale designating language to use in communications with this customer.
 * @param priority Priority of the customer.
 * @param pucNumber (if applicable) Public utilities commission (PUC) identification number.
 * @param specialNeed True if customer organisation has special service needs such as life support, hospitals, etc.
 * @param status Status of this customer.
 * @param vip (use 'priority' instead) True if this is an important customer.
 *        Importance is for matters different than those in 'specialNeed' attribute.
 * @param Works All the works performed for this customer.
 */
case class Customer
(
    override val sup: OrganisationRole,
    kind: String,
    locale: String,
    priority: String,
    pucNumber: String,
    specialNeed: String,
    status: String,
    vip: Boolean,
    Works: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, false, List()) }
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[Customer] }
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
        (if (null != kind) "\t\t<cim:Customer.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != locale) "\t\t<cim:Customer.locale>" + locale + "</cim:Customer.locale>\n" else "") +
        (if (null != priority) "\t\t<cim:Customer.priority rdf:resource=\"#" + priority + "\"/>\n" else "") +
        (if (null != pucNumber) "\t\t<cim:Customer.pucNumber>" + pucNumber + "</cim:Customer.pucNumber>\n" else "") +
        (if (null != specialNeed) "\t\t<cim:Customer.specialNeed>" + specialNeed + "</cim:Customer.specialNeed>\n" else "") +
        (if (null != status) "\t\t<cim:Customer.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        "\t\t<cim:Customer.vip>" + vip + "</cim:Customer.vip>\n" +
        (if (null != Works) Works.map (x => "\t\t<cim:Customer.Works rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Customer rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Customer>"
    }
}

object Customer
extends
    Parseable[Customer]
{
    val kind: (Context) => String = parse_attribute (attribute ("""Customer.kind"""))
    val locale: (Context) => String = parse_element (element ("""Customer.locale"""))
    val priority: (Context) => String = parse_attribute (attribute ("""Customer.priority"""))
    val pucNumber: (Context) => String = parse_element (element ("""Customer.pucNumber"""))
    val specialNeed: (Context) => String = parse_element (element ("""Customer.specialNeed"""))
    val status: (Context) => String = parse_attribute (attribute ("""Customer.status"""))
    val vip: (Context) => String = parse_element (element ("""Customer.vip"""))
    val Works: (Context) => List[String] = parse_attributes (attribute ("""Customer.Works"""))
    def parse (context: Context): Customer =
    {
        Customer(
            OrganisationRole.parse (context),
            kind (context),
            locale (context),
            priority (context),
            pucNumber (context),
            specialNeed (context),
            status (context),
            toBoolean (vip (context), context),
            Works (context)
        )
    }
}

/**
 * Assignment of a group of products and services purchased by the customer through a customer agreement, used as a mechanism for customer billing and payment.
 * It contains common information from the various types of customer agreements to create billings (invoices) for a customer and receive payment.
 * @param sup Reference to the superclass object.
 * @param billingCycle Cycle day on which the associated customer account will normally be billed, used to determine when to produce the billing.
 * @param budgetBill Budget bill code.
 * @param Customer Customer owning this account.
 */
case class CustomerAccount
(
    override val sup: Document,
    billingCycle: String,
    budgetBill: String,
    Customer: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[CustomerAccount] }
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
        (if (null != billingCycle) "\t\t<cim:CustomerAccount.billingCycle>" + billingCycle + "</cim:CustomerAccount.billingCycle>\n" else "") +
        (if (null != budgetBill) "\t\t<cim:CustomerAccount.budgetBill>" + budgetBill + "</cim:CustomerAccount.budgetBill>\n" else "") +
        (if (null != Customer) "\t\t<cim:CustomerAccount.Customer rdf:resource=\"#" + Customer + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CustomerAccount rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CustomerAccount>"
    }
}

object CustomerAccount
extends
    Parseable[CustomerAccount]
{
    val billingCycle: (Context) => String = parse_element (element ("""CustomerAccount.billingCycle"""))
    val budgetBill: (Context) => String = parse_element (element ("""CustomerAccount.budgetBill"""))
    val Customer: (Context) => String = parse_attribute (attribute ("""CustomerAccount.Customer"""))
    def parse (context: Context): CustomerAccount =
    {
        CustomerAccount(
            Document.parse (context),
            billingCycle (context),
            budgetBill (context),
            Customer (context)
        )
    }
}

/**
 * Agreement between the customer and the service supplier to pay for service at a specific service location.
 * It records certain billing information about the type of service provided at the service location and is used during charge creation to determine the type of service.
 * @param sup Reference to the superclass object.
 * @param loadMgmt Load management code.
 * @param Customer Customer for this agreement.
 * @param CustomerAccount Customer account owning this agreement.
 * @param PricingStructures All pricing structures applicable to this customer agreement.
 * @param ServiceCategory Service category for this agreement.
 * @param ServiceLocations All service locations regulated by this customer agreement.
 * @param ServiceSupplier Service supplier for this customer agreement.
 * @param StandardIndustryCode <em>undocumented</em>
 */
case class CustomerAgreement
(
    override val sup: Agreement,
    loadMgmt: String,
    Customer: String,
    CustomerAccount: String,
    PricingStructures: List[String],
    ServiceCategory: String,
    ServiceLocations: List[String],
    ServiceSupplier: String,
    StandardIndustryCode: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, List(), null, List(), null, null) }
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { clone ().asInstanceOf[CustomerAgreement] }
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
        (if (null != loadMgmt) "\t\t<cim:CustomerAgreement.loadMgmt>" + loadMgmt + "</cim:CustomerAgreement.loadMgmt>\n" else "") +
        (if (null != Customer) "\t\t<cim:CustomerAgreement.Customer rdf:resource=\"#" + Customer + "\"/>\n" else "") +
        (if (null != CustomerAccount) "\t\t<cim:CustomerAgreement.CustomerAccount rdf:resource=\"#" + CustomerAccount + "\"/>\n" else "") +
        (if (null != PricingStructures) PricingStructures.map (x => "\t\t<cim:CustomerAgreement.PricingStructures rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ServiceCategory) "\t\t<cim:CustomerAgreement.ServiceCategory rdf:resource=\"#" + ServiceCategory + "\"/>\n" else "") +
        (if (null != ServiceLocations) ServiceLocations.map (x => "\t\t<cim:CustomerAgreement.ServiceLocations rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ServiceSupplier) "\t\t<cim:CustomerAgreement.ServiceSupplier rdf:resource=\"#" + ServiceSupplier + "\"/>\n" else "") +
        (if (null != StandardIndustryCode) "\t\t<cim:CustomerAgreement.StandardIndustryCode rdf:resource=\"#" + StandardIndustryCode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CustomerAgreement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CustomerAgreement>"
    }
}

object CustomerAgreement
extends
    Parseable[CustomerAgreement]
{
    val loadMgmt: (Context) => String = parse_element (element ("""CustomerAgreement.loadMgmt"""))
    val Customer: (Context) => String = parse_attribute (attribute ("""CustomerAgreement.Customer"""))
    val CustomerAccount: (Context) => String = parse_attribute (attribute ("""CustomerAgreement.CustomerAccount"""))
    val PricingStructures: (Context) => List[String] = parse_attributes (attribute ("""CustomerAgreement.PricingStructures"""))
    val ServiceCategory: (Context) => String = parse_attribute (attribute ("""CustomerAgreement.ServiceCategory"""))
    val ServiceLocations: (Context) => List[String] = parse_attributes (attribute ("""CustomerAgreement.ServiceLocations"""))
    val ServiceSupplier: (Context) => String = parse_attribute (attribute ("""CustomerAgreement.ServiceSupplier"""))
    val StandardIndustryCode: (Context) => String = parse_attribute (attribute ("""CustomerAgreement.StandardIndustryCode"""))
    def parse (context: Context): CustomerAgreement =
    {
        CustomerAgreement(
            Agreement.parse (context),
            loadMgmt (context),
            Customer (context),
            CustomerAccount (context),
            PricingStructures (context),
            ServiceCategory (context),
            ServiceLocations (context),
            ServiceSupplier (context),
            StandardIndustryCode (context)
        )
    }
}

/**
 * Conditions for notifying the customer about the changes in the status of their service (e.g., outage restore, estimated restoration time, tariff or service level change, etc.)
 * @param sup Reference to the superclass object.
 * @param contactType Type of contact (e.g., phone, email, etc.).
 * @param contactValue Value of contact type (e.g., phone number, email address, etc.).
 * @param earliestDateTimeToCall Earliest date time to call the customer.
 * @param latestDateTimeToCall Latest date time to call the customer.
 * @param trigger Trigger for this notification.
 * @param Customer Customer requiring this notification.
 * @param Incident Incident as a subject of this customer notification.
 */
case class CustomerNotification
(
    override val sup: BasicElement,
    contactType: String,
    contactValue: String,
    earliestDateTimeToCall: String,
    latestDateTimeToCall: String,
    trigger: String,
    Customer: String,
    Incident: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[CustomerNotification] }
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
        (if (null != contactType) "\t\t<cim:CustomerNotification.contactType>" + contactType + "</cim:CustomerNotification.contactType>\n" else "") +
        (if (null != contactValue) "\t\t<cim:CustomerNotification.contactValue>" + contactValue + "</cim:CustomerNotification.contactValue>\n" else "") +
        (if (null != earliestDateTimeToCall) "\t\t<cim:CustomerNotification.earliestDateTimeToCall>" + earliestDateTimeToCall + "</cim:CustomerNotification.earliestDateTimeToCall>\n" else "") +
        (if (null != latestDateTimeToCall) "\t\t<cim:CustomerNotification.latestDateTimeToCall>" + latestDateTimeToCall + "</cim:CustomerNotification.latestDateTimeToCall>\n" else "") +
        (if (null != trigger) "\t\t<cim:CustomerNotification.trigger rdf:resource=\"#" + trigger + "\"/>\n" else "") +
        (if (null != Customer) "\t\t<cim:CustomerNotification.Customer rdf:resource=\"#" + Customer + "\"/>\n" else "") +
        (if (null != Incident) "\t\t<cim:CustomerNotification.Incident rdf:resource=\"#" + Incident + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CustomerNotification rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CustomerNotification>"
    }
}

object CustomerNotification
extends
    Parseable[CustomerNotification]
{
    val contactType: (Context) => String = parse_element (element ("""CustomerNotification.contactType"""))
    val contactValue: (Context) => String = parse_element (element ("""CustomerNotification.contactValue"""))
    val earliestDateTimeToCall: (Context) => String = parse_element (element ("""CustomerNotification.earliestDateTimeToCall"""))
    val latestDateTimeToCall: (Context) => String = parse_element (element ("""CustomerNotification.latestDateTimeToCall"""))
    val trigger: (Context) => String = parse_attribute (attribute ("""CustomerNotification.trigger"""))
    val Customer: (Context) => String = parse_attribute (attribute ("""CustomerNotification.Customer"""))
    val Incident: (Context) => String = parse_attribute (attribute ("""CustomerNotification.Incident"""))
    def parse (context: Context): CustomerNotification =
    {
        CustomerNotification(
            BasicElement.parse (context),
            contactType (context),
            contactValue (context),
            earliestDateTimeToCall (context),
            latestDateTimeToCall (context),
            trigger (context),
            Customer (context),
            Incident (context)
        )
    }
}

/**
 * Hazardous situation associated with an incident.
 * Examples are line down, gas leak, fire, etc.
 * @param sup Reference to the superclass object.
 * @param Incident Incident associated with this hazard.
 * @param TroubleTicket Trouble ticket associated with this hazard.
 */
case class IncidentHazard
(
    override val sup: Hazard,
    Incident: String,
    TroubleTicket: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Hazard: Hazard = sup.asInstanceOf[Hazard]
    override def copy (): Row = { clone ().asInstanceOf[IncidentHazard] }
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
        (if (null != Incident) "\t\t<cim:IncidentHazard.Incident rdf:resource=\"#" + Incident + "\"/>\n" else "") +
        (if (null != TroubleTicket) "\t\t<cim:IncidentHazard.TroubleTicket rdf:resource=\"#" + TroubleTicket + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:IncidentHazard rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:IncidentHazard>"
    }
}

object IncidentHazard
extends
    Parseable[IncidentHazard]
{
    val Incident: (Context) => String = parse_attribute (attribute ("""IncidentHazard.Incident"""))
    val TroubleTicket: (Context) => String = parse_attribute (attribute ("""IncidentHazard.TroubleTicket"""))
    def parse (context: Context): IncidentHazard =
    {
        IncidentHazard(
            Hazard.parse (context),
            Incident (context),
            TroubleTicket (context)
        )
    }
}

/**
 * Grouping of pricing components and prices used in the creation of customer charges and the eligibility criteria under which these terms may be offered to a customer.
 * The reasons for grouping include state, customer classification, site characteristics, classification (i.e. fee price structure, deposit price structure, electric service price structure, etc.) and accounting requirements.
 * @param sup Reference to the superclass object.
 * @param code Unique user-allocated key for this pricing structure, used by company representatives to identify the correct price structure for allocating to a customer.
 *        For rate schedules it is often prefixed by a state code.
 * @param dailyCeilingUsage Absolute maximum valid non-demand usage quantity used in validating a customer's billed non-demand usage.
 * @param dailyEstimatedUsage Used in place of actual computed estimated average when history of usage is not available, and typically manually entered by customer accounting.
 * @param dailyFloorUsage Absolute minimum valid non-demand usage quantity used in validating a customer's billed non-demand usage.
 * @param revenueKind (accounting) Kind of revenue, often used to determine the grace period allowed, before collection actions are taken on a customer (grace periods vary between revenue classes).
 * @param taxExemption True if this pricing structure is not taxable.
 * @param ServiceCategory Service category to which this pricing structure applies.
 * @param Tariffs All tariffs used by this pricing structure.
 * @param UsagePoints All service delivery points (with prepayment meter running as a stand-alone device, with no CustomerAgreement or Customer) to which this pricing structure applies.
 */
case class PricingStructure
(
    override val sup: Document,
    code: String,
    dailyCeilingUsage: Int,
    dailyEstimatedUsage: Int,
    dailyFloorUsage: Int,
    revenueKind: String,
    taxExemption: Boolean,
    ServiceCategory: String,
    Tariffs: List[String],
    UsagePoints: List[String]
)
extends
    Element
{
    def this () = { this (null, null, 0, 0, 0, null, false, null, List(), List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[PricingStructure] }
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
        (if (null != code) "\t\t<cim:PricingStructure.code>" + code + "</cim:PricingStructure.code>\n" else "") +
        "\t\t<cim:PricingStructure.dailyCeilingUsage>" + dailyCeilingUsage + "</cim:PricingStructure.dailyCeilingUsage>\n" +
        "\t\t<cim:PricingStructure.dailyEstimatedUsage>" + dailyEstimatedUsage + "</cim:PricingStructure.dailyEstimatedUsage>\n" +
        "\t\t<cim:PricingStructure.dailyFloorUsage>" + dailyFloorUsage + "</cim:PricingStructure.dailyFloorUsage>\n" +
        (if (null != revenueKind) "\t\t<cim:PricingStructure.revenueKind rdf:resource=\"#" + revenueKind + "\"/>\n" else "") +
        "\t\t<cim:PricingStructure.taxExemption>" + taxExemption + "</cim:PricingStructure.taxExemption>\n" +
        (if (null != ServiceCategory) "\t\t<cim:PricingStructure.ServiceCategory rdf:resource=\"#" + ServiceCategory + "\"/>\n" else "") +
        (if (null != Tariffs) Tariffs.map (x => "\t\t<cim:PricingStructure.Tariffs rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != UsagePoints) UsagePoints.map (x => "\t\t<cim:PricingStructure.UsagePoints rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:PricingStructure rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PricingStructure>"
    }
}

object PricingStructure
extends
    Parseable[PricingStructure]
{
    val code: (Context) => String = parse_element (element ("""PricingStructure.code"""))
    val dailyCeilingUsage: (Context) => String = parse_element (element ("""PricingStructure.dailyCeilingUsage"""))
    val dailyEstimatedUsage: (Context) => String = parse_element (element ("""PricingStructure.dailyEstimatedUsage"""))
    val dailyFloorUsage: (Context) => String = parse_element (element ("""PricingStructure.dailyFloorUsage"""))
    val revenueKind: (Context) => String = parse_attribute (attribute ("""PricingStructure.revenueKind"""))
    val taxExemption: (Context) => String = parse_element (element ("""PricingStructure.taxExemption"""))
    val ServiceCategory: (Context) => String = parse_attribute (attribute ("""PricingStructure.ServiceCategory"""))
    val Tariffs: (Context) => List[String] = parse_attributes (attribute ("""PricingStructure.Tariffs"""))
    val UsagePoints: (Context) => List[String] = parse_attributes (attribute ("""PricingStructure.UsagePoints"""))
    def parse (context: Context): PricingStructure =
    {
        PricingStructure(
            Document.parse (context),
            code (context),
            toInteger (dailyCeilingUsage (context), context),
            toInteger (dailyEstimatedUsage (context), context),
            toInteger (dailyFloorUsage (context), context),
            revenueKind (context),
            toBoolean (taxExemption (context), context),
            ServiceCategory (context),
            Tariffs (context),
            UsagePoints (context)
        )
    }
}

/**
 * Category of service provided to the customer.
 * @param sup Reference to the superclass object.
 * @param kind Kind of service.
 */
case class ServiceCategory
(
    override val sup: IdentifiedObject,
    kind: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ServiceCategory] }
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
        (if (null != kind) "\t\t<cim:ServiceCategory.kind rdf:resource=\"#" + kind + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ServiceCategory rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ServiceCategory>"
    }
}

object ServiceCategory
extends
    Parseable[ServiceCategory]
{
    val kind: (Context) => String = parse_attribute (attribute ("""ServiceCategory.kind"""))
    def parse (context: Context): ServiceCategory =
    {
        ServiceCategory(
            IdentifiedObject.parse (context),
            kind (context)
        )
    }
}

/**
 * A real estate location, commonly referred to as premises.
 * @param sup Reference to the superclass object.
 * @param accessMethod Method for the service person to access this service location.
 *        For example, a description of where to obtain a key if the facility is unmanned and secured.
 * @param needsInspection True if inspection is needed of facilities at this service location.
 *        This could be requested by a customer, due to suspected tampering, environmental concerns (e.g., a fire in the vicinity), or to correct incompatible data.
 * @param siteAccessProblem Problems previously encountered when visiting or performing work on this location.
 *        Examples include: bad dog, violent customer, verbally abusive occupant, obstructions, safety hazards, etc.
 */
case class ServiceLocation
(
    override val sup: WorkLocation,
    accessMethod: String,
    needsInspection: Boolean,
    siteAccessProblem: String
)
extends
    Element
{
    def this () = { this (null, null, false, null) }
    def WorkLocation: WorkLocation = sup.asInstanceOf[WorkLocation]
    override def copy (): Row = { clone ().asInstanceOf[ServiceLocation] }
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
        (if (null != accessMethod) "\t\t<cim:ServiceLocation.accessMethod>" + accessMethod + "</cim:ServiceLocation.accessMethod>\n" else "") +
        "\t\t<cim:ServiceLocation.needsInspection>" + needsInspection + "</cim:ServiceLocation.needsInspection>\n" +
        (if (null != siteAccessProblem) "\t\t<cim:ServiceLocation.siteAccessProblem>" + siteAccessProblem + "</cim:ServiceLocation.siteAccessProblem>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ServiceLocation rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ServiceLocation>"
    }
}

object ServiceLocation
extends
    Parseable[ServiceLocation]
{
    val accessMethod: (Context) => String = parse_element (element ("""ServiceLocation.accessMethod"""))
    val needsInspection: (Context) => String = parse_element (element ("""ServiceLocation.needsInspection"""))
    val siteAccessProblem: (Context) => String = parse_element (element ("""ServiceLocation.siteAccessProblem"""))
    def parse (context: Context): ServiceLocation =
    {
        ServiceLocation(
            WorkLocation.parse (context),
            accessMethod (context),
            toBoolean (needsInspection (context), context),
            siteAccessProblem (context)
        )
    }
}

/**
 * Document, approved by the responsible regulatory agency, listing the terms and conditions, including a schedule of prices, under which utility services will be provided.
 * It has a unique number within the state or province. For rate schedules it is frequently allocated by the affiliated Public utilities commission (PUC).
 * @param sup Reference to the superclass object.
 * @param endDate (if tariff became inactive) Date tariff was terminated.
 * @param startDate Date tariff was activated.
 * @param TariffProfiles All tariff profiles using this tariff.
 */
case class Tariff
(
    override val sup: Document,
    endDate: String,
    startDate: String,
    TariffProfiles: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[Tariff] }
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
        (if (null != endDate) "\t\t<cim:Tariff.endDate>" + endDate + "</cim:Tariff.endDate>\n" else "") +
        (if (null != startDate) "\t\t<cim:Tariff.startDate>" + startDate + "</cim:Tariff.startDate>\n" else "") +
        (if (null != TariffProfiles) TariffProfiles.map (x => "\t\t<cim:Tariff.TariffProfiles rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Tariff rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Tariff>"
    }
}

object Tariff
extends
    Parseable[Tariff]
{
    val endDate: (Context) => String = parse_element (element ("""Tariff.endDate"""))
    val startDate: (Context) => String = parse_element (element ("""Tariff.startDate"""))
    val TariffProfiles: (Context) => List[String] = parse_attributes (attribute ("""Tariff.TariffProfiles"""))
    def parse (context: Context): Tariff =
    {
        Tariff(
            Document.parse (context),
            endDate (context),
            startDate (context),
            TariffProfiles (context)
        )
    }
}

case class TroubleTicket
(
    override val sup: Document,
    dateTimeOfReport: String,
    firstResponder: String,
    reportingKind: String,
    resolvedDateTime: String,
    troubleCode: String,
    Customer: String,
    Incident: String,
    Notification: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[TroubleTicket] }
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
        (if (null != dateTimeOfReport) "\t\t<cim:TroubleTicket.dateTimeOfReport>" + dateTimeOfReport + "</cim:TroubleTicket.dateTimeOfReport>\n" else "") +
        (if (null != firstResponder) "\t\t<cim:TroubleTicket.firstResponder>" + firstResponder + "</cim:TroubleTicket.firstResponder>\n" else "") +
        (if (null != reportingKind) "\t\t<cim:TroubleTicket.reportingKind rdf:resource=\"#" + reportingKind + "\"/>\n" else "") +
        (if (null != resolvedDateTime) "\t\t<cim:TroubleTicket.resolvedDateTime>" + resolvedDateTime + "</cim:TroubleTicket.resolvedDateTime>\n" else "") +
        (if (null != troubleCode) "\t\t<cim:TroubleTicket.troubleCode>" + troubleCode + "</cim:TroubleTicket.troubleCode>\n" else "") +
        (if (null != Customer) "\t\t<cim:TroubleTicket.Customer rdf:resource=\"#" + Customer + "\"/>\n" else "") +
        (if (null != Incident) "\t\t<cim:TroubleTicket.Incident rdf:resource=\"#" + Incident + "\"/>\n" else "") +
        (if (null != Notification) "\t\t<cim:TroubleTicket.Notification rdf:resource=\"#" + Notification + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TroubleTicket rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TroubleTicket>"
    }
}

object TroubleTicket
extends
    Parseable[TroubleTicket]
{
    val dateTimeOfReport: (Context) => String = parse_element (element ("""TroubleTicket.dateTimeOfReport"""))
    val firstResponder: (Context) => String = parse_element (element ("""TroubleTicket.firstResponder"""))
    val reportingKind: (Context) => String = parse_attribute (attribute ("""TroubleTicket.reportingKind"""))
    val resolvedDateTime: (Context) => String = parse_element (element ("""TroubleTicket.resolvedDateTime"""))
    val troubleCode: (Context) => String = parse_element (element ("""TroubleTicket.troubleCode"""))
    val Customer: (Context) => String = parse_attribute (attribute ("""TroubleTicket.Customer"""))
    val Incident: (Context) => String = parse_attribute (attribute ("""TroubleTicket.Incident"""))
    val Notification: (Context) => String = parse_attribute (attribute ("""TroubleTicket.Notification"""))
    def parse (context: Context): TroubleTicket =
    {
        TroubleTicket(
            Document.parse (context),
            dateTimeOfReport (context),
            firstResponder (context),
            reportingKind (context),
            resolvedDateTime (context),
            troubleCode (context),
            Customer (context),
            Incident (context),
            Notification (context)
        )
    }
}

private[ninecode] object _Customers
{
    def register: List[ClassInfo] =
    {
        List (
            Customer.register,
            CustomerAccount.register,
            CustomerAgreement.register,
            CustomerNotification.register,
            IncidentHazard.register,
            PricingStructure.register,
            ServiceCategory.register,
            ServiceLocation.register,
            Tariff.register,
            TroubleTicket.register
        )
    }
}