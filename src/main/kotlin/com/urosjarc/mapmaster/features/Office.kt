package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.domain.OsmFeature
import com.urosjarc.mapmaster.domain.OsmNode
import com.urosjarc.mapmaster.domain.OsmRel
import com.urosjarc.mapmaster.domain.OsmWay

/**
 * This file is auto generated!
 */

data class OfficeNode(
    val node: OsmNode,
    val type: OfficeType
)

data class OfficeWay(
    val way: OsmWay,
    val type: OfficeType
)

data class OfficeRel(
    val rel: OsmRel,
    val type: OfficeType
)

data class OfficeFeatures(
    val nodes: MutableList<OfficeNode> = mutableListOf(),
    val ways: MutableList<OfficeWay> = mutableListOf(),
    val rels: MutableList<OfficeRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["office"]
        val type = OfficeType.entries.firstOrNull { it.value == enumValue }
            ?: OfficeType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(OfficeNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(OfficeRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(OfficeWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class OfficeType(val value: String) {
    ACCOUNTANT("accountant"),           // An office for an accountant.
    ADMINISTRATIVE("administrative"),   // Using this tag is discouraged, use tag:office=government instead.
    ADVERTISING_AGENCY("advertising_agency"), // A service-based business dedicated to creating, planning, and handling advertising.
    ARCHITECT("architect"),             // An office for an architect or group of architects.
    ASSOCIATION("association"),         // An office of a non-profit organisation, society, e.g. student, sport, consumer, automobile, bike association, etc.
    CHAMBER("chamber"),                 // Seat of a professional chamber, such as bar associations.
    CHARITY("charity"),                 // An office of a charitable organization
    COMPANY("company"),                 // An office of a private company.
    CONSTRUCTION_COMPANY("construction_company"), // An office of a construction company.
    CONSULTING("consulting"),           // An office for a consulting firm, providing expert professional advice to other companies or organisations.
    COURIER("courier"),                 // A courier delivery service, which is neither a post office or a national post.
    COWORKING("coworking"),             // An office where people can go to work (typically requires a fee); not limited to a single employer
    DIPLOMATIC("diplomatic"),           // An embassy, diplomatic mission, consulate or liaison office of a foreign government or parastatal entity in a host country.
    EDUCATIONAL_INSTITUTION("educational_institution"), // An office for an educational institution.
    EMPLOYMENT_AGENCY("employment_agency"), // An office for an employment service.
    ENERGY_SUPPLIER("energy_supplier"), // An office for a energy supplier.
    ENGINEER("engineer"),               // An office for an engineer or group of engineers.
    ESTATE_AGENT("estate_agent"),       // A place where you can rent or buy a house.
    FINANCIAL("financial"),             // An office of a company in the financial sector
    FINANCIAL_ADVISOR("financial_advisor"), // A professional who offers financial planning and sells financial services to clients.
    FORESTRY("forestry"),               // A forestry office
    FOUNDATION("foundation"),           // An office of a foundation
    GEODESIST("geodesist"),             // An office of a person doing land surveys.
    GOVERNMENT("government"),           // An office of a (supra)national, regional or local government agency or department
    GRAPHIC_DESIGN("graphic_design"),   // An office of a graphic designer.
    GUIDE("guide"),                     // An office of tour guides, mountain guides, hiking guides, dive guides, etc.
    HARBOUR_MASTER("harbour_master"),   // The Harbourmaster's office
    INSURANCE("insurance"),             // An office at which you can take out insurance policies.
    IT("it"),                           // An office for an IT specialist.
    LAWYER("lawyer"),                   // An office for a lawyer.
    LOGISTICS("logistics"),             // An office for a forwarder / hauler.
    MOVING_COMPANY("moving_company"),   // An office which offers a relocation service.
    NEWSPAPER("newspaper"),             // An office of a newspaper
    NGO("ngo"),                         // An office for a non-profit, non-governmental organisation (NGO).
    NOTARY("notary"),                   // An office for a notary public (common law)
    POLITICIAN("politician"),           // A politician's office.
    POLITICAL_PARTY("political_party"), // An office of a political party
    PROPERTY_MANAGEMENT("property_management"), // Office of a property rental company for residential apartments or commercial office space.
    PUBLISHER("publisher"),             // An office of a publisher.
    QUANGO("quango"),                   // An office of a quasi-autonomous non-governmental organisation.
    RELIGION("religion"),               // office of a community of faith
    RESEARCH("research"),               // An office for research and development
    SECURITY("security"),               // An office for private security guards
    SURVEYOR("surveyor"),               // An office of a person doing technical surveys, such as land surveys or risk and damage evaluations of properties and equipment.
    TAX_ADVISOR("tax_advisor"),         // An office for a financial expert specially trained in tax law
    TELECOMMUNICATION("telecommunication"), // An office for a telecommunication company
    THERAPIST("therapist"),             // An office of a therapist.
    TRAVEL_AGENT("travel_agent"),       // An office of a travel agent.
    TUTORING("tutoring"),               // An office of tutor or tutoring centre.
    UNION("union"),                     // An office of a trade union, an association of workers forming a bargaining unit
    VISA("visa"),                       // An office of an organisation or business which offers visa assistance
    WATER_UTILITY("water_utility"),     // The office for a water utility company or water board.
    YES("yes"),                         // Generic tag for unspecified office type.
    OTHER("other")
}
