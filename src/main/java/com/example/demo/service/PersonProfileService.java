public interface PersonProfileService {

    PersonProfile createProfile(PersonProfile person);

    PersonProfile findById(Long id);

    PersonProfile findByReferenceId(String referenceId);

    List<PersonProfile> getAllProfiles();
}
