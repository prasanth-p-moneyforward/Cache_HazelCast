package com.prasanth.cache.service

import com.hazelcast.core.HazelcastInstance
import com.prasanth.cache.entity.WhitelistIpaddress
import com.prasanth.cache.repository.WhiteListIPAddressRepo
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentMap

@Service
class WhiteListIPAddressService(
    private val whiteListIPAddressRepo: WhiteListIPAddressRepo,
    private val hazelcastInstance: HazelcastInstance
) {
    private fun getWhiteListIPAddressCacheKey(): ConcurrentMap<String, WhitelistIpaddress>{
        return hazelcastInstance.getMap("whiteListIPAddress")
    }
    fun getWhiteListIPAddress(clientName: String): WhitelistIpaddress? {
        var whitelistIpaddress = getWhiteListIPAddressCacheKey()[clientName]
        if(whitelistIpaddress == null) {
            println("Getting Data from DB")
            whitelistIpaddress = whiteListIPAddressRepo.findByClientName(clientName)
            if (whitelistIpaddress == null) return null
            getWhiteListIPAddressCacheKey()[whitelistIpaddress.clientName!!] = whitelistIpaddress
        }
        return whitelistIpaddress
    }

    fun updateWhiteListIPAddress(clientName: String, whitelistIpaddress: WhitelistIpaddress): WhitelistIpaddress {
        getWhiteListIPAddressCacheKey()[whitelistIpaddress.clientName!!] = whitelistIpaddress
        return whitelistIpaddress
    }

}