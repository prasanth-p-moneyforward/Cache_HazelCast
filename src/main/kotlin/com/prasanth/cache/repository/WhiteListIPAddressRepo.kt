package com.prasanth.cache.repository

import com.prasanth.cache.entity.WhitelistIpaddress
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WhiteListIPAddressRepo: JpaRepository<WhitelistIpaddress, Int> {
    fun findByClientName(clientName: String): WhitelistIpaddress?
}