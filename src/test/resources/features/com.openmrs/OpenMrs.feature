Feature: Open MRS tests

  @openMrs
  Scenario: Register a patient
    Given the user logs in to OpenMRS with following credentials
      | username | admin    |
      | password | Admin123 |
    When the user registers a new patient with following information
      | GivenName    | Ugur       |
      | FamilyName   | Ucar       |
      | Gender       | Male       |
      | Day          | 8          |
      | Month        | January    |
      | Year         | 1991       |
      | Address      | 2200       |
      | City         | Des Plains |
      | State        | IL         |
      | Country      | US         |
      | ZipCode      | 77777      |
      | PhoneNumber  | 3147148300 |
      | relationType | Doctor     |
      | RelativeName | Potel      |
    Then the user validates the patient name and familyName
      | GivenName    | Ugur       |
      | FamilyName   | Ucar       |