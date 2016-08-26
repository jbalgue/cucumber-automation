$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("TestGoogle.feature");
formatter.feature({
  "line": 2,
  "name": "Test Google",
  "description": "I want to use this template for my feature file",
  "id": "test-google",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@tag"
    }
  ]
});
formatter.scenarioOutline({
  "line": 6,
  "name": "Able to access Google",
  "description": "",
  "id": "test-google;able-to-access-google",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I access Google site, \u003curl\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I should be navigated to Google site",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "test-google;able-to-access-google;",
  "rows": [
    {
      "cells": [
        "url"
      ],
      "line": 11,
      "id": "test-google;able-to-access-google;;1"
    },
    {
      "cells": [
        "{serverUrl}"
      ],
      "line": 12,
      "id": "test-google;able-to-access-google;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 12,
  "name": "Able to access Google",
  "description": "",
  "id": "test-google;able-to-access-google;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@tag"
    },
    {
      "line": 5,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I access Google site, {serverUrl}",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I should be navigated to Google site",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "{serverUrl}",
      "offset": 22
    }
  ],
  "location": "TestGoogle.i_access_Google_site_www_google_com_ph(String)"
});
formatter.result({
  "duration": 8221480622,
  "status": "passed"
});
formatter.match({
  "location": "TestGoogle.i_should_be_navigated_to_Google_site()"
});
formatter.result({
  "duration": 51057022,
  "status": "passed"
});
formatter.after({
  "duration": 218385965,
  "status": "passed"
});
});