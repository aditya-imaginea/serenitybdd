Expanding URL story

Narrative:
In order to display a link to a shortened URL correctly
As a web site author
I want to be able to expand shortened URLs to their long form

Scenario: Expanding URLS
Given a url <providedURL>
When I request the expanded form of this url
Then the long form should be <expectedURL>
Examples:
| providedURL | expectedURL |
| http://goo.gl/fbsS | http://www.google.com |
| http://goo.gl/xj57 | http://www.amazon.com |
