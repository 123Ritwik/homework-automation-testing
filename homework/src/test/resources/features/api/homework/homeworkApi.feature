@homeworkApi @api
Feature: Test homework api positive and negative scenario

  @creates
    #positivePost
  Scenario Outline: To Create new homework
    Given Request to homework "/hmwk/homeworks"
      | headersKey   | headersValue     |
      | Content-Type | application/json |
      | Accept       | application/json |
    When Creates a new homework "createHomework.json"
      | assignedBy   | assignedTo   | section   | course   | subject   | standard   | workType   | homeWorkDate   | homeDueDate   | fileName   |
      | <assignedBy> | <assignedTo> | <section> | <course> | <subject> | <standard> | <workType> | <homeWorkDate> | <homeDueDate> | <fileName> |
    Then Validates the response code 201
    And Validates the response with JSON schema "schemaHomework.json"

    Examples:
      | assignedBy | assignedTo | section  | course | subject | standard   | workType   | homeWorkDate            | homeDueDate             | fileName |
      | user012    | user23     | SectionA | BTech  | Maths   | FirstYear  | Group      | 2023-08-25T06:07:25.83Z | 2023-09-25T06:07:25.83Z | hw.txt   |
      | user012    | user34     | SectionB | BTech  | Maths   | SecondYear | Individual | 2023-08-25T06:07:25.83Z | 2023-09-25T06:07:25.83Z | hw.txt   |
      | user012    | user24     | SectionC | BTech  | Maths   | FirstYear  | Group      | 2023-08-25T06:07:25.83Z | 2023-09-25T06:07:25.83Z | hw.txt   |
  @negativePost
  Scenario Outline: To create new homework with invalid scenario
    Given Request to homework "/hmwk/homeworks"
      | headersKey   | headersValue     |
      | Content-Type | application/json |
      | Accept       | application/json |
    When Creates a new homework "createHomework.json"
      | assignedBy   | assignedTo   | section   | course   | subject   | standard   | workType   | homeWorkDate   | homeDueDate   | fileName   |
      | <assignedBy> | <assignedTo> | <section> | <course> | <subject> | <standard> | <workType> | <homeWorkDate> | <homeDueDate> | <fileName> |
    Then Validates the response code 201
    And Validates the response with JSON schema "schemaHomework.json"

    Examples:
      | assignedBy | assignedTo | section  | course | subject | standard   | workType   | homeWorkDate            | homeDueDate             | fileName |
      |            | user23     | SectionA | BTech  |         | FirstYear  | Group      |                         | 2023-09-25T06:07:25.83Z | hw.txt   |
      | user012    |            |          | BTech  | Maths   | SecondYear | Individual | 2023-08-25T06:07:25.83Z | 2023-09-25T06:07:25.83Z | hw.txt   |
      | user012    | user24     |          |        | Maths   | FirstYear  | Group      | 2023-08-25T06:07:25.83Z | 2023-09-25T06:07:25.83Z | hw.txt   |

  @getPositive
  Scenario Outline: Get Homeworks
    Given Request to homework "/hmwk/homeworks"
      | headersKey   | headersValue     |
      | Content-Type | application/json |
      | Accept       | application/json |
    When pass a valid filter parameters
      | page   | size   | direction   | section     | course     | subject     | standard   | homeWorkDate   | assignedBy   | assignedTo   |
      | <page> | <size> | <direction> | "<section>" | "<course>" | "<subject>" | <standard> | <homeWorkDate> | <assignedBy> | <assignedTo> |
    Then Validates the response code 201
    And Validates the response with JSON schema "schemaHomework.json"
    Examples:
      | page | size | direction | section  | course | subject | standard | homeWorkDate            | assignedBy | assignedTo |
      | 10   | 50   | ASCENDING | SectionA | BTech  | Maths   | BTech    | 2023-08-25T06:07:25.83Z | User189    | User567    |
      | 11   | 50   | ASCENDING | SectionB | BTech  | Maths   |          | 2023-08-25T06:07:25.83Z | User23     | User356    |

  @getNegative
  Scenario Outline: Get Homeworks
    Given Request to homework "/hmwk/homeworks"
      | headersKey   | headersValue     |
      | Content-Type | application/json |
      | Accept       | application/json |
    When pass a valid filter parameters
      | page   | size   | direction   | section     | course     | subject     | standard   | homeWorkDate   | assignedBy   | assignedTo   |
      | <page> | <size> | <direction> | "<section>" | "<course>" | "<subject>" | <standard> | <homeWorkDate> | <assignedBy> | <assignedTo> |
    Then Validates the response code 406
    And Validates the response with JSON schema "schemaHomework.json"
    Examples:
      | page | size | direction | section   | course | subject | standard | homeWorkDate | assignedBy | assignedTo |
      | 0    | -50  | Ascending | Section A | BTech  | Maths   | BTech    |              | User189    | User567    |
      | -1   | 50   | Ascending | Section A | BTech  | Maths   | BTech    |              | User189    | User567    |

  @positivePut
  Scenario Outline: To update existing homework
    Given Request to homework "/hmwk/homeworks/{homeworkId}"
      | headersKey   | headersValue     |
      | Content-Type | application/json |
      | Accept       | application/json |
    When update a valid filter parameters "createHomework.json"
      | id   | assignedBy   | assignedTo   | section   | course   | subject   | workType   | homeWorkDate   | homeDueDate   | fileName   |
      | <id> | <assignedBy> | <assignedTo> | <section> | <course> | <subject> | <workType> | <homeWorkDate> | <homeDueDate> | <fileName> |
    Then Validates the response code 201
    And Validates the response with JSON schema "schemaHomework.json"
    Examples:
      | id                                   | assignedBy | assignedTo | section  | course | subject | workType | homeWorkDate            | homeDueDate             | fileName |
      | 1ccec626-89c9-4298-8fd1-af15ba7dbef0 | user012    | user345    | SectionA | BTech  | English | Group    | 2023-08-25T06:07:25.83Z | 2023-09-25T06:07:25.83Z | hw.txt   |
      | 6c0cd72b-04c1-4981-a2c1-231da1b821b2 | user012    | user345    | SectionA | BTech  | English | Group    | 2023-08-25T06:07:25.83Z | 2023-09-25T06:07:25.83Z | hw.txt   |

  @negativePut
  Scenario Outline: To update existing homework with invalid credentials
    Given Request to homework "/hmwk/homeworks/{homeworkId}"
      | headersKey   | headersValue     |
      | Content-Type | application/json |
      | Accept       | application/json |
    When update a valid filter parameters "createHomework.json"
      | id   | assignedBy   | assignedTo   | section   | course   | subject   | workType   | homeWorkDate   | homeDueDate   | fileName   |
      | <id> | <assignedBy> | <assignedTo> | <section> | <course> | <subject> | <workType> | <homeWorkDate> | <homeDueDate> | <fileName> |
    Then Validates the response code 406
    And Validates the response with JSON schema "schemaHomework.json"
    Examples:
      | id                                   | assignedBy | assignedTo | section  | course | subject | workType | homeWorkDate            | homeDueDate             | fileName |
      | 1ccec626-89c9-4298-8fd1-af15ba7dbef0 | user 012   | user345    |          | BTech  | English | Group    | 2023-08-25T06:07:25.83Z | 2023-09-25T06:07:25.83Z | hw.txt   |
      | 6c0cd72b-04c1-4981-a2c1-231da1b821b2 | user 012   | user345    | sectionA | BTech  |         | Group    | 2023-08-25T06:07:25.83Z | 2023-09-25T06:07:25.83Z | hw.txt   |

  @positiveGetbyId
  Scenario Outline: Get Homework by Id
    Given Request to homework "/hmwk/homeworks/{homeworkId}"
      | headersKey   | headersValue     |
      | Content-Type | application/json |
      | Accept       | application/json |
    When pass a valid filter homework id "createHomework.json"
      | homeworkId   |
      | <homeworkId> |
    Then Validates the response code 200
    And Validates the response with JSON schema "schemaHomework.json"
    Examples:
      | homeworkId                           |
      | 01f011e8-5b81-4a1c-8cf2-22e2dc9d7c8c |

  @negativeGetbyId
  Scenario Outline: Get Homework by invalid Id
    Given Request to homework "/hmwk/homeworks/{homeworkId}"
      | headersKey   | headersValue     |
      | Content-Type | application/json |
      | Accept       | application/json |
    When pass a valid filter homework id "createHomework.json"
      | homeworkId   |
      | <homeworkId> |
    Then Validates the response code 422
    And Validates the response with JSON schema "schemaHomework.json"
    Examples:
      | homeworkId                          |
      | 3fa85f64-5717-4562-b3fc-2c963f66afa |
      | 6c0cd72b-04c1-4981-c1-231da1b821b2  |

  @positiveDelete
  Scenario Outline: Delete homework
    Given Request to homework "/hmwk/homeworks/{homeworkId}"
      | headersKey   | headersValue     |
      | Content-Type | application/json |
      | Accept       | application/json |
    When Delete parameter in homework id "createHomework.json"
      | homeworkId   |
      | <homeworkId> |
    Then Validates the response code 204
    And Validates the response with JSON schema "schemaHomework.json"
    Examples:
      | homeworkId                           |
      | 3fa85f64-5717-4562-b3fc-2c963f66afa6 |
      | 6c0cd72b-04c1-4981-a2c1-231da1b821b2 |

  @negativeDelete
  Scenario Outline: Delete homework by invalid id
    Given Request to homework "/hmwk/homeworks/{homeworkId}"
      | headersKey   | headersValue     |
      | Content-Type | application/json |
      | Accept       | application/json |
    When Delete parameter in homework id "createHomework.json"
      | homeworkId   |
      | <homeworkId> |
    Then Validates the response code 422
    And Validates the response with JSON schema "schemaHomework.json"
    Examples:
      | homeworkId                         |
      | 3fa85f64-5717-4562-b3fc-2c963f6    |
      | 6c0cd72b-04c1-4981-a2c1-231da1b821 |

