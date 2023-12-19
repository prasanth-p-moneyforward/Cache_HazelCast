package com.prasanth.cache.controller

import com.prasanth.cache.entity.WhitelistIpaddress
import com.prasanth.cache.service.WhiteListIPAddressService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WhiteListController(
    private val whiteListIPAddressService: WhiteListIPAddressService
) {

    // Get WhiteList IP Address based on clientName
    @GetMapping("/whitelist/{clientName}")
    fun getWhiteListIPAddress(@PathVariable clientName: String):ResponseEntity<Any>{
        val whitelistIpaddress = whiteListIPAddressService.getWhiteListIPAddress(clientName)
            ?: return ResponseEntity.badRequest().body("No Data available")
        return ResponseEntity.ok(whitelistIpaddress)
    }

    @PutMapping("/whitelist/{clientName}")
    fun updateWhiteListIPAddress(clientName: String, whitelistIpaddress: WhitelistIpaddress) =
        whiteListIPAddressService.updateWhiteListIPAddress(clientName, whitelistIpaddress)
}