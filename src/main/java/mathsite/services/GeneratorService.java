package mathsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mathproblems.generator.builders.FractionProblemBuilder;
import mathproblems.generator.builders.SimpleProblemBuilder;

@Service
public class GeneratorService {

	@Autowired
	private SimpleProblemBuilder simpleProblemBuilder;

	@Autowired
	private FractionProblemBuilder fractionProblemBuilder;

}
