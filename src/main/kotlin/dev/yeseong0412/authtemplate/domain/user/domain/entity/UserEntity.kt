package dev.yeseong0412.authtemplate.domain.user.domain.entity

import jakarta.persistence.*

@Entity
class UserEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long, // ID (PK)

    @Column(nullable = false)
    val email: String, // Email

    @Column(nullable = false)
    val password: String, // Password

)