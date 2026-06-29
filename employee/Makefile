# Build the service
build:
	./mvnw clean package -DskipTests

# Generate initial changelog from DB
generate-changelog:
	./mvnw liquibase:generateChangeLog

# Generate diff after entity changes
diff:
	./mvnw liquibase:diff

# Apply pending migrations
update:
	./mvnw liquibase:update

# Rollback last migration
rollback:
	./mvnw liquibase:rollbackCount -Dliquibase.rollbackCount=1

# Build Docker image
docker:
	docker build -t employee-service:latest .
	docker save employee-service:latest | sudo k3s ctr images import -