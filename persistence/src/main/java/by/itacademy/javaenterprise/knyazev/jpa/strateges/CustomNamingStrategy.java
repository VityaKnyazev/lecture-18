package by.itacademy.javaenterprise.knyazev.jpa.strateges;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomNamingStrategy implements PhysicalNamingStrategy{

	@Override
	public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		return convert(name);
	}

	@Override
	public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		return convert(name);
	}

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		return convert(name);
	}

	@Override
	public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		return convert(name);
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		return convert(name);
	}
	
	private Identifier convert(final Identifier name) {
		if (name == null) return null;
		
		final String regex = "([a-z])([A-Z])";
        final String replacement = "$1_$2";
        final String newName = name.getText()
          .replaceAll(regex, replacement)
          .toLowerCase();
        return Identifier.toIdentifier(newName);
	}
}