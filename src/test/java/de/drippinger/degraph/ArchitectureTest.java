package de.drippinger.degraph;

import org.junit.Test;

import static de.schauderhaft.degraph.check.Check.classpath;
import static de.schauderhaft.degraph.check.JCheck.violationFree;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ArchitectureTest {

	@Test
	public void should_be_free_of_cycles() {
		assertThat(classpath()
					.noJars()
					.including("de.drippinger"),
				is(violationFree()));
	}

}
