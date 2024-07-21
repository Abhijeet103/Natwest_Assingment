# Configurable Report Generator

## Overview

The Configurable Report Generator is a Java Spring Boot service designed to ingest CSV files, apply transformation rules defined in a `Transformation.properties` file, and generate transformed reports. The transformed data is exported as a CSV file, which can be downloaded via a controller layer. The service also includes a scheduling function to generate reports at configurable intervals, with logging and unit testing in place to ensure reliability and maintainability.

## Features

- **Configurable Transformation Rules**: Define transformation rules in `Transformation.properties` file.
- **Repository Layer**: Stores CSV data in a HashMap for easy access.
- **Service Layer**: Reads rules, performs transformations, and exports the transformed data as a CSV file.
- **Controller Layer**: Provides endpoints for downloading the CSV file and scheduling report generation.
- **Scheduling**: Generates reports at a configurable interval (default is every 1 hour).
- **Logging**: Comprehensive logging for debugging and monitoring.
- **Unit Testing**: Ensures the correctness of transformations and overall functionality.

## Transformation Rules

Transformation rules are defined in the `Transformation.properties` file. Each rule specifies how to transform the input fields and reference keys to generate the output fields. The syntax for defining rules is as follows:

```properties
outfield1 = add(field1, field2)
outfield2 = ref(refkey1)
outfield3 = add(ref(refkey2), ref(refkey3))
outfield4 = mul(field3, max(field5, ref(refkey4)))
outfield5 = max(field5, ref(refkey4))
```

## Architecture

### Repository Layer

- Stores CSV data in a HashMap for efficient access and manipulation.

### Service Layer

- Reads transformation rules from `Transformation.properties`.
- Uses the Repository Layer to perform all transformations.
- Exports the transformed data as a CSV file.

### Controller Layer

- Provides endpoints to download the generated CSV file.
- Includes a scheduling function to generate reports at configurable intervals.

## Main Transformation Algorithm

The main algorithm for applying transformation rules involves the following steps:

1. Convert each rule into a stack.
2. Perform operations by popping one element for references (e.g., `ref(refkey)`) and two elements for binary operations (e.g., `add`, `max`).
3. Repeat for each item in the field and store the result in the corresponding output field.

### Example

For the rule `outfield4 = mul(field3, max(field5, ref(refkey4)))`:
- Convert to stack: `[mul, field3, max, field5, ref(refkey4)]`
- Process `ref(refkey4)` -> get reference value.
- Process `max(field5, reference value)` -> get maximum value.
- Process `mul(field3, max value)` -> get the product.
- Store result in `outfield4`.

