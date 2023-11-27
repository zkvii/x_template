import pymysql
import yaml
import os
import re

# Path to your YAML file
config_yaml='./src/main/resources/application.yaml'
# Define a regex pattern to extract host and database name
pattern = r"jdbc:mysql://([^:/]+):(\d+)/(.+)\?"
try:
    with open(config_yaml, 'r') as file:
        # Load YAML data into a Python dictionary
        yaml_data = yaml.safe_load(file)

except FileNotFoundError:
    print(f"File '{config_yaml}' not found.")
except yaml.YAMLError as e:
    print(f"Error parsing YAML file: {e}")


# MySQL database connection configuration
url = yaml_data['spring']['datasource']['url']
user = yaml_data['spring']['datasource']['username']
password = yaml_data['spring']['datasource']['password']
match = re.match(pattern, url)

if match:
    host = match.group(1)
    port = match.group(2)
    database = match.group(3)

    print(f"Host: {host}")
    print(f"Port: {port}")
    print(f"Database: {database}")
else:
    print("No match found.")
    
try:
    # Establishing a connection to the database
    connection = pymysql.connect(
        host=host,
        user=user,
        password=password,
        database=database,
        port=int(port),
    )

    # Creating a cursor object using cursor() method
    cursor = connection.cursor()

    # Executing a SQL query
    cursor.execute("SELECT VERSION()")

    # Fetching the result
    db_version = cursor.fetchone()
    print(f"Database version: {db_version}")
    
    
    query = "SELECT table_name FROM information_schema.tables WHERE table_schema = %s"
    cursor.execute(query, (database,))

    # Fetching the result
    tables = cursor.fetchall()
    
    # Printing all table names
    print("Tables in the database:")
    for table in tables:
        print(table[0])
    
    

except pymysql.Error as e:
    print(f"Error connecting to MySQL database: {e}")

finally:
    # Closing the database connection
    if connection:
        connection.close()
