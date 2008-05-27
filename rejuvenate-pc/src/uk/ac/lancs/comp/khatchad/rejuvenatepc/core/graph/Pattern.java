/**
 * 
 */
package uk.ac.lancs.comp.khatchad.rejuvenatepc.core.graph;

import java.util.Collection;
import java.util.Set;

import org.eclipse.ajdt.core.javaelements.AdviceElement;
import org.jdom.Element;

import ca.mcgill.cs.swevo.jayfx.model.IElement;

/**
 * @author raffi
 * 
 */
public class Pattern<E extends IntentionEdge<IElement>> extends Path<E> {

	/**
	 * The weight assigned to precision, for confidence calculation.
	 */
	public static final double WEIGHT_PRECISION = 0.75;

	private static final long serialVersionUID = -8126850132892419370L;

	public static double calculateConfidence(final double precision,
			final double concreteness, final double weight_precision) {
		final double result = precision * weight_precision + (1 - concreteness)
				* (1 - weight_precision);
		return Math.max(result, precision);
	}
	
	public static double calculateConfidence(final double precision,
			final double concreteness) {
		final double result = precision * WEIGHT_PRECISION + (1 - concreteness)
				* (1 - WEIGHT_PRECISION);
		return Math.max(result, precision);
	}

	public static double calculatePrecision(
			final Set<IntentionElement<IElement>> searchedFor,
			final Set<IntentionElement<IElement>> found) {
		final int totalElements = found.size();
		final int lookingFor = searchedFor.size();
		return (double) lookingFor / totalElements;
	}

	/**
	 * @param pattern
	 * @return
	 */
	public static double calculateConcreteness(
			final Path<IntentionEdge<IElement>> pattern) {
		final Collection<IntentionNode<IElement>> allNodes = pattern.getNodes();
		final Collection<IntentionNode<IElement>> wildNodes = pattern
				.getWildcardNodes();
		return (double) (allNodes.size() - wildNodes.size())
				/ allNodes.size();
	}
}