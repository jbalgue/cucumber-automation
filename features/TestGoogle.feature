@tag
Feature: Test Google
	I want to use this template for my feature file

@tag1
Scenario Outline: Able to access Google
Given I access Google site, <url>
Then I should be navigated to Google site

Examples:
    | url  |
    | {serverUrl} |
