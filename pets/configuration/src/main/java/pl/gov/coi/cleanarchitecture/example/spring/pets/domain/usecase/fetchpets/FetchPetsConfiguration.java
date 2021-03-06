package pl.gov.coi.cleanarchitecture.example.spring.pets.domain.usecase.fetchpets;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.gov.coi.cleanarchitecture.example.spring.pets.domain.contract.PetContract;
import pl.gov.coi.cleanarchitecture.example.spring.pets.domain.logic.EntityReferenceMapper;
import pl.gov.coi.cleanarchitecture.example.spring.pets.domain.mapper.EnumMapper;
import pl.gov.coi.cleanarchitecture.example.spring.pets.domain.model.entity.Race;
import pl.gov.coi.cleanarchitecture.example.spring.pets.domain.model.gateway.PetsGateway;
import pl.gov.coi.cleanarchitecture.example.spring.pets.transactional.TransactionalBeanProvider;

/**
 * @author <a href="krzysztof.suszynski@wavesoftware.pl">Krzysztof Suszyński</a>
 * @since 2017-01-06
 */
@Configuration
@EnableTransactionManagement
class FetchPetsConfiguration {
  @Bean
  FetchPetsUseCase provideFetchPetsUseCase(PetsGateway petsGateway,
                                           EnumMapper<PetContract.Race, Race> raceEnumMapper,
                                           EntityReferenceMapper entityReferenceMapper,
                                           TransactionalBeanProvider transactionalBeanProvider) {
    return transactionalBeanProvider.transactional(
      () -> new FetchPetsUseCaseImpl(
        petsGateway,
        raceEnumMapper,
        entityReferenceMapper
      )
    );
  }
}
