package org.nlamah.QL.Builders;

import org.nlamah.QBase.Tools.ArrayTools;
import org.nlamah.QL.Model.Form.ConditionalBlock;
import org.nlamah.QL.View.Controllers.ConditionalBlockAllViewController;
import org.nlamah.QL.View.Controllers.ConditionalBlockIfElseIfViewController;
import org.nlamah.QL.View.Controllers.ConditionalBlockIfElseViewController;
import org.nlamah.QL.View.Controllers.ConditionalBlockIfViewController;
import org.nlamah.QL.View.Controllers.ConditionalBlockViewController;

public class ConditionalBlockViewControllerFactory 
{
	static public ConditionalBlockViewController createConditionalBlockViewController(ConditionalBlock conditionalBlock)
	{
		boolean ifThenBlockExists = ifThenBlockExists(conditionalBlock);
		boolean elseIfThenBlocksExist = elseIfThenBlocksExist(conditionalBlock);
		boolean elseThenBlockExists = elseThenBlockExists(conditionalBlock);

		if (ifThenBlockExists && elseIfThenBlocksExist && elseThenBlockExists)
		{
			return new ConditionalBlockAllViewController(conditionalBlock);
		}

		if (ifThenBlockExists && !elseIfThenBlocksExist && elseThenBlockExists)
		{
			return new ConditionalBlockIfElseViewController(conditionalBlock);
		}

		if (ifThenBlockExists && elseIfThenBlocksExist && !elseThenBlockExists)
		{
			return new ConditionalBlockIfElseIfViewController(conditionalBlock);
		}

		if (ifThenBlockExists && !elseIfThenBlocksExist && !elseThenBlockExists)
		{
			return new ConditionalBlockIfViewController(conditionalBlock);
		}

		if (ifThenBlockExists && !elseIfThenBlocksExist && !elseThenBlockExists)
		{
			assert false;
		}

		if (!ifThenBlockExists && (elseIfThenBlocksExist || elseThenBlockExists))
		{
			assert false;
		}

		return null;
	}

	static private boolean ifThenBlockExists(ConditionalBlock conditionalBlock)
	{
		return conditionalBlock.ifThenBlock() != null;
	}

	static private boolean elseIfThenBlocksExist(ConditionalBlock conditionalBlock)
	{
		return ArrayTools.arrayExistsAndHasElements(conditionalBlock.elseIfThenBlocks());
	}

	static private boolean elseThenBlockExists(ConditionalBlock conditionalBlock)
	{
		return conditionalBlock.elseThenBlock() != null;
	}
}