# csv_or_raw_text_recursive_search_and_classifier
a command line tool that performs classification of textual content stored in files and folders into business domains.

INPUT
The program will receive the following command-line arguments:
1. Path in the filesystem representing a file or a folder that should be scanned.
2. Path to a JSON file, representing the list of classification rules:

{
"classification_rules": [
{"domain": "financial", "indicators": ["credit card", "bank account"]},
{"domain": "healthcare", "indicators": ["medical insurance"]}
]
}

The file consists of a single object with a list field named "classification_rules". Each element in the
list represents a rule with the following fields:
"domain": a string representing a business domain, like financial, healthcare, etc.
"indicators": a list of strings, indicating that the scanned content belongs to the "domain".

OUTPUT
The program should extract text from files under the provided path and to classify it into one or more domains. The text is
classified into some "domain"
For instance, given the classification rules above and the input file:
