package dev.yeseong0412.authtemplate.global.common


/**
 * Domain 클래스를 Entity 클래스로, Entity 클래스를 Domain 클래스로 변환해주는 인터페이스 <br>
 * 반드시 각각의 타입은 변환이 가능한 형태이어야 합니다.
 * @param <D> Domain 모듈에 위치한 Domain 클래스
 * @param <E> 인프라스트럭쳐 모듈에 위치한 Entity 클래스
 */
interface Mapper<D, E> {

    /**
     * Entity 클래스를 인자로 Domain 클래스로 변환합니다.
     * @param entity Entity 인스턴스를 인자로 받습니다.
     * @return Domain 클래스를 반환합니다.
     */
    fun toDomain(entity: E): D

    /**
     * Domain 클래스를 인자로 Entity 클래스로 변환합니다.
     * @param domain Domain 인스턴스를 인자로 받습니다.
     * @return Entity 클래스를 반환합니다.
     */
    fun toEntity(domain: D): E
}