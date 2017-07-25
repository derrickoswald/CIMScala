package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/*
 * Package: Assets
 */

case class AcceptanceTest
(
    override val sup: BasicElement,
    val dateTime: String,
    val success: Boolean,
    val typ: String  // type
)
extends
    Element
{
    def this () = { this (null, null, false, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AcceptanceTest]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AcceptanceTest
extends
    Parseable[AcceptanceTest]
{
    val dateTime = parse_element (element ("""AcceptanceTest.dateTime"""))
    val success = parse_element (element ("""AcceptanceTest.success"""))
    val typ = parse_element (element ("""AcceptanceTest.typ"""))
    def parse (context: Context): AcceptanceTest =
    {
        return (
            AcceptanceTest
            (
                BasicElement.parse (context),
                dateTime (context),
                toBoolean (success (context), context),
                typ (context)
            )
        )
    }
}

case class Asset
(
    override val sup: IdentifiedObject,
    val critical: Boolean,
    val initialCondition: String,
    val initialLossOfLife: Double,
    val lotNumber: String,
    val purchasePrice: Double,  // decimal
    val serialNumber: String,
    val typ: String,  // type
    val utcNumber: String,
    val AssetContainer: String,
    val AssetInfo: String,
    val ErpInventory: String,
    val ErpItemMaster: String,
    val FinancialInfo: String,
    val Location: String,
    val PowerSystemResources: List[String],
    val acceptanceTest: String,
    val electronicAddress: String,
    val lifecycle: String,
    val status: String
)
extends
    Element
{
    def this () = { this (null, false, null, 0.0, null, 0.0, null, null, null, null, null, null, null, null, null, List(), null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Asset]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Asset
extends
    Parseable[Asset]
{
    val critical = parse_element (element ("""Asset.critical"""))
    val initialCondition = parse_element (element ("""Asset.initialCondition"""))
    val initialLossOfLife = parse_element (element ("""Asset.initialLossOfLife"""))
    val lotNumber = parse_element (element ("""Asset.lotNumber"""))
    val purchasePrice = parse_element (element ("""Asset.purchasePrice"""))
    val serialNumber = parse_element (element ("""Asset.serialNumber"""))
    val typ = parse_element (element ("""Asset.type"""))
    val utcNumber = parse_element (element ("""Asset.utcNumber"""))
    val AssetContainer = parse_attribute (attribute ("""Asset.AssetContainer"""))
    val AssetInfo = parse_attribute (attribute ("""Asset.AssetInfo"""))
    val ErpInventory = parse_attribute (attribute ("""Asset.ErpInventory"""))
    val ErpItemMaster = parse_attribute (attribute ("""Asset.ErpItemMaster"""))
    val FinancialInfo = parse_attribute (attribute ("""Asset.FinancialInfo"""))
    val Location = parse_attribute (attribute ("""Asset.Location"""))
    val PowerSystemResources = parse_attributes (attribute ("""Asset.PowerSystemResources"""))
    val acceptanceTest = parse_attribute (attribute ("""Asset.acceptanceTest"""))
    val electronicAddress = parse_attribute (attribute ("""Asset.electronicAddress"""))
    val lifecycle = parse_attribute (attribute ("""Asset.lifecycle"""))
    val status = parse_attribute (attribute ("""Asset.status"""))
    def parse (context: Context): Asset =
    {
        return (
            Asset
            (
                IdentifiedObject.parse (context),
                toBoolean (critical (context), context),
                initialCondition (context),
                toDouble (initialLossOfLife (context), context),
                lotNumber (context),
                toDouble (purchasePrice (context), context),
                serialNumber (context),
                typ (context),
                utcNumber (context),
                AssetContainer (context),
                AssetInfo (context),
                ErpInventory (context),
                ErpItemMaster (context),
                FinancialInfo (context),
                Location (context),
                PowerSystemResources (context),
                acceptanceTest (context),
                electronicAddress (context),
                lifecycle (context),
                status (context)
            )
        )
    }
}

case class AssetContainer
(
    override val sup: Asset
)
extends
    Element
{
    def this () = { this (null) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetContainer]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetContainer
extends
    Parseable[AssetContainer]
{
    def parse (context: Context): AssetContainer =
    {
        return (
            AssetContainer
            (
                Asset.parse (context)
            )
        )
    }
}

case class AssetFunction
(
    override val sup: IdentifiedObject,
    val configID: String,
    val firmwareID: String,
    val hardwareID: String,
    val password: String,
    val programID: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetFunction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetFunction
extends
    Parseable[AssetFunction]
{
    val configID = parse_element (element ("""AssetFunction.configID"""))
    val firmwareID = parse_element (element ("""AssetFunction.firmwareID"""))
    val hardwareID = parse_element (element ("""AssetFunction.hardwareID"""))
    val password = parse_element (element ("""AssetFunction.password"""))
    val programID = parse_element (element ("""AssetFunction.programID"""))
    def parse (context: Context): AssetFunction =
    {
        return (
            AssetFunction
            (
                IdentifiedObject.parse (context),
                configID (context),
                firmwareID (context),
                hardwareID (context),
                password (context),
                programID (context)
            )
        )
    }
}

case class AssetInfo
(
    override val sup: IdentifiedObject,
    val AssetModel: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetInfo
extends
    Parseable[AssetInfo]
{
    val AssetModel = parse_attribute (attribute ("""AssetInfo.AssetModel"""))
    def parse (context: Context): AssetInfo =
    {
        return (
            AssetInfo
            (
                IdentifiedObject.parse (context),
                AssetModel (context)
            )
        )
    }
}

case class AssetLocationHazard
(
    override val sup: Hazard
)
extends
    Element
{
    def this () = { this (null) }
    def Hazard: Hazard = sup.asInstanceOf[Hazard]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetLocationHazard]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetLocationHazard
extends
    Parseable[AssetLocationHazard]
{
    def parse (context: Context): AssetLocationHazard =
    {
        return (
            AssetLocationHazard
            (
                Hazard.parse (context)
            )
        )
    }
}

case class AssetModel
(
    override val sup: IdentifiedObject,
    val AssetInfo: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetModel]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetModel
extends
    Parseable[AssetModel]
{
    val AssetInfo = parse_attribute (attribute ("""AssetModel.AssetInfo"""))
    def parse (context: Context): AssetModel =
    {
        return (
            AssetModel
            (
                IdentifiedObject.parse (context),
                AssetInfo (context)
            )
        )
    }
}

case class AssetOrganisationRole
(
    override val sup: OrganisationRole
)
extends
    Element
{
    def this () = { this (null) }
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetOrganisationRole]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetOrganisationRole
extends
    Parseable[AssetOrganisationRole]
{
    def parse (context: Context): AssetOrganisationRole =
    {
        return (
            AssetOrganisationRole
            (
                OrganisationRole.parse (context)
            )
        )
    }
}

case class AssetOwner
(
    override val sup: AssetOrganisationRole
)
extends
    Element
{
    def this () = { this (null) }
    def AssetOrganisationRole: AssetOrganisationRole = sup.asInstanceOf[AssetOrganisationRole]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetOwner]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetOwner
extends
    Parseable[AssetOwner]
{
    def parse (context: Context): AssetOwner =
    {
        return (
            AssetOwner
            (
                AssetOrganisationRole.parse (context)
            )
        )
    }
}

case class AssetUser
(
    override val sup: AssetOrganisationRole
)
extends
    Element
{
    def this () = { this (null) }
    def AssetOrganisationRole: AssetOrganisationRole = sup.asInstanceOf[AssetOrganisationRole]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetUser]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetUser
extends
    Parseable[AssetUser]
{
    def parse (context: Context): AssetUser =
    {
        return (
            AssetUser
            (
                AssetOrganisationRole.parse (context)
            )
        )
    }
}

case class ComMedia
(
    override val sup: Asset
)
extends
    Element
{
    def this () = { this (null) }
    def Asset: Asset = sup.asInstanceOf[Asset]
    override def copy (): Row = { return (clone ().asInstanceOf[ComMedia]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ComMedia
extends
    Parseable[ComMedia]
{
    def parse (context: Context): ComMedia =
    {
        return (
            ComMedia
            (
                Asset.parse (context)
            )
        )
    }
}

case class LifecycleDate
(
    override val sup: BasicElement,
    val installationDate: String,  // date
    val manufacturedDate: String,
    val purchaseDate: String,
    val receivedDate: String,
    val removalDate: String,
    val retiredDate: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[LifecycleDate]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LifecycleDate
extends
    Parseable[LifecycleDate]
{
    val installationDate = parse_element (element ("""LifecycleDate.installationDate"""))
    val manufacturedDate = parse_element (element ("""LifecycleDate.manufacturedDate"""))
    val purchaseDate = parse_element (element ("""LifecycleDate.purchaseDate"""))
    val receivedDate = parse_element (element ("""LifecycleDate.receivedDate"""))
    val removalDate = parse_element (element ("""LifecycleDate.removalDate"""))
    val retiredDate = parse_element (element ("""LifecycleDate.retiredDate"""))
    def parse (context: Context): LifecycleDate =
    {
        return (
            LifecycleDate
            (
                BasicElement.parse (context),
                installationDate (context),
                manufacturedDate (context),
                purchaseDate (context),
                receivedDate (context),
                removalDate (context),
                retiredDate (context)
            )
        )
    }
}

case class Maintainer
(
    override val sup: AssetOrganisationRole
)
extends
    Element
{
    def this () = { this (null) }
    def AssetOrganisationRole: AssetOrganisationRole = sup.asInstanceOf[AssetOrganisationRole]
    override def copy (): Row = { return (clone ().asInstanceOf[Maintainer]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Maintainer
extends
    Parseable[Maintainer]
{
    def parse (context: Context): Maintainer =
    {
        return (
            Maintainer
            (
                AssetOrganisationRole.parse (context)
            )
        )
    }
}

case class Manufacturer
(
    override val sup: OrganisationRole
)
extends
    Element
{
    def this () = { this (null) }
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { return (clone ().asInstanceOf[Manufacturer]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Manufacturer
extends
    Parseable[Manufacturer]
{
    def parse (context: Context): Manufacturer =
    {
        return (
            Manufacturer
            (
                OrganisationRole.parse (context)
            )
        )
    }
}

case class Procedure
(
    override val sup: Document,
    val instruction: String,
    val kind: String,
    val sequenceNumber: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[Procedure]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Procedure
extends
    Parseable[Procedure]
{
    val instruction = parse_element (element ("""Procedure.instruction"""))
    val kind = parse_attribute (attribute ("""Procedure.kind"""))
    val sequenceNumber = parse_element (element ("""Procedure.sequenceNumber"""))
    def parse (context: Context): Procedure =
    {
        return (
            Procedure
            (
                Document.parse (context),
                instruction (context),
                kind (context),
                sequenceNumber (context)
            )
        )
    }
}

case class ProcedureDataSet
(
    override val sup: Document,
    val completedDateTime: String,
    val Procedure: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[ProcedureDataSet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProcedureDataSet
extends
    Parseable[ProcedureDataSet]
{
    val completedDateTime = parse_element (element ("""ProcedureDataSet.completedDateTime"""))
    val Procedure = parse_attribute (attribute ("""ProcedureDataSet.Procedure"""))
    def parse (context: Context): ProcedureDataSet =
    {
        return (
            ProcedureDataSet
            (
                Document.parse (context),
                completedDateTime (context),
                Procedure (context)
            )
        )
    }
}

case class ProductAssetModel
(
    override val sup: AssetModel,
    val corporateStandardKind: String,
    val modelNumber: String,
    val modelVersion: String,
    val usageKind: String,
    val weightTotal: Double,
    val GenericAssetModelOrMaterial: String,
    val Manufacturer: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, 0.0, null, null) }
    def AssetModel: AssetModel = sup.asInstanceOf[AssetModel]
    override def copy (): Row = { return (clone ().asInstanceOf[ProductAssetModel]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProductAssetModel
extends
    Parseable[ProductAssetModel]
{
    val corporateStandardKind = parse_attribute (attribute ("""ProductAssetModel.corporateStandardKind"""))
    val modelNumber = parse_element (element ("""ProductAssetModel.modelNumber"""))
    val modelVersion = parse_element (element ("""ProductAssetModel.modelVersion"""))
    val usageKind = parse_attribute (attribute ("""ProductAssetModel.usageKind"""))
    val weightTotal = parse_element (element ("""ProductAssetModel.weightTotal"""))
    val GenericAssetModelOrMaterial = parse_attribute (attribute ("""ProductAssetModel.GenericAssetModelOrMaterial"""))
    val Manufacturer = parse_attribute (attribute ("""ProductAssetModel.Manufacturer"""))
    def parse (context: Context): ProductAssetModel =
    {
        return (
            ProductAssetModel
            (
                AssetModel.parse (context),
                corporateStandardKind (context),
                modelNumber (context),
                modelVersion (context),
                usageKind (context),
                toDouble (weightTotal (context), context),
                GenericAssetModelOrMaterial (context),
                Manufacturer (context)
            )
        )
    }
}

case class Seal
(
    override val sup: IdentifiedObject,
    val appliedDateTime: String,
    val condition: String,
    val kind: String,
    val sealNumber: String,
    val AssetContainer: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Seal]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Seal
extends
    Parseable[Seal]
{
    val appliedDateTime = parse_element (element ("""Seal.appliedDateTime"""))
    val condition = parse_attribute (attribute ("""Seal.condition"""))
    val kind = parse_attribute (attribute ("""Seal.kind"""))
    val sealNumber = parse_element (element ("""Seal.sealNumber"""))
    val AssetContainer = parse_attribute (attribute ("""Seal.AssetContainer"""))
    def parse (context: Context): Seal =
    {
        return (
            Seal
            (
                IdentifiedObject.parse (context),
                appliedDateTime (context),
                condition (context),
                kind (context),
                sealNumber (context),
                AssetContainer (context)
            )
        )
    }
}

object _Assets
{
    def register: Unit =
    {
        AcceptanceTest.register
        Asset.register
        AssetContainer.register
        AssetFunction.register
        AssetInfo.register
        AssetLocationHazard.register
        AssetModel.register
        AssetOrganisationRole.register
        AssetOwner.register
        AssetUser.register
        ComMedia.register
        LifecycleDate.register
        Maintainer.register
        Manufacturer.register
        Procedure.register
        ProcedureDataSet.register
        ProductAssetModel.register
        Seal.register
    }
}
