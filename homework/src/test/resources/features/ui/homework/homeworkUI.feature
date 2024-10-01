@api
Feature: Admin web

  Background: Launch the Application
    Given Launch the admin-web

  @Admin
  Scenario: Verify the layout
    Given Verify page title