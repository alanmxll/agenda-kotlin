package business

import entity.ContactEntity
import repository.ContactRepository

class ContactBusiness {

    fun validate(name: String, phone: String) {
        if (name == "") {
            throw Exception("Name is required.")
        }
        if (phone == "") {
            throw  Exception("Phone is required.")
        }
    }

    fun validateDelete(name: String, phone: String) {
        if (name == "" || phone == "") {
            throw Exception("You must select a contact before removing.")
        }
    }

    fun save(name: String, phone: String) {
        validate(name, phone)

        val contact = ContactEntity(name, phone)
        ContactRepository.save(contact)
    }

    fun delete(name: String, phone: String) {
        validateDelete(name, phone)

        val contact = ContactEntity(name, phone)
        ContactRepository.delete(contact)
    }

}