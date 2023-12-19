package com.prasanth.cache.entity

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "whitelist_ipaddress")
open class WhitelistIpaddress: Serializable {
    @Id
    @Column(name = "whitelist_id", nullable = false)
    open var id: Int? = null

    @Column(name = "client_name", nullable = false, length = 32)
    open var clientName: String? = null

    @Column(name = "ip_address", length = 32)
    open var ipAddress: String? = null

    @Column(name = "is_allow_all_on", nullable = false)
    open var isAllowAllOn: Boolean? = false

    @Column(name = "create_user", length = 32)
    open var createUser: String? = null

    @Column(name = "create_datetime")
    open var createDatetime: LocalDateTime? = null

    @Column(name = "update_user", length = 32)
    open var updateUser: String? = null

    @Column(name = "update_datetime")
    open var updateDatetime: LocalDateTime? = null
}
