# wsAITest

Automated "an unread gmail and verify the correct link" using Java and Selenium

************************
Before the test: create a test gmail account.
Using another email account, send several email messages to this account, with some of them (at least 4) containing the following text:
------------------------
Subject: Forgot your Password?
Body: Dear customer,
Sorry you've been having trouble logging into your account. You can reset your password by following this link.
Thanks,
The Wysdom.AI Crew
---------------------
Where the link ('this link') would lead to wysdom.ai 

Write a test scenario for Selenium that will:
a. Log in to this gmail account
b. Find the 'Forgot your Password?' email
c. Click on the link in this email
d. Verify that you are on wysdom.ai
