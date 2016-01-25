﻿#summary Instructions on how to use the plugin.

Once the plugin is properly installed, two choices on the refactoring context menu should appear when an advice declaration is selected in any Eclipse view. An example is below:

![http://rejuvenate-pc.googlecode.com/files/screenshot2.png](http://rejuvenate-pc.googlecode.com/files/screenshot2.png)

  1. The _Analyze Pointcut_ selection analyzes the underlying intention patterns in the base-code in which the advice applies. In fact, you may analyze all advice contained within a project by selecting the project's context menu and then selecting _Analyze Pointcut_. Keep in mind that pointcuts can not be rejuvenated unless they are **analyzed first**.
  1. The _Rejuvenate Pointcut_ selection populates the _Suggestions_ view with suggested join point shadows for corresponding advice. Unlike _Analyze Pointcut_, the _Rejuvenate Pointcut_ selection may only be executed on a single advice.
  1. Once the _Rejuvenate Pointcut_ selection has been executed, the next step is to _view_ the suggestions. Open the _Show View_ dialog in Eclipse, scroll down to the AspectJ folder, expand it, and select the _Suggestions_ view.

You should now be able to see all the suggestions for your rejuvenated pointcut. Note that if the list appears empty, please make sure that the enclosing aspect is focused in the UI either by clicking on its source editor window, its icon in the _Outline_ view, etc.

### How to read the suggestions ###

The _Suggestion_ view is populated with join points very much like the traditional _Cross References_ view, however, the join points presented are not currently being advised but, instead, suggested. Double clicking on any row will focus the UI on the corresponding code associated with the join point, i.e., the _join point shadow_. The join point suggestions are sorted by their _confidence_ in decreasing order by default. The corresponding _intention pattern_ used to derive the suggestion is presented for informational purposes.