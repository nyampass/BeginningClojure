<div class="bs-callout bs-callout-danger">
 <h3>MongoDB Configuration is Required</h3>
 <p>Before continuing please follow the steps below to configure your MongoDB connection.</p>
 <ol>
   <li> Ensure that MongoDB is up and running.
   <li> Add the connection parameters in the <code>luminus-sample.models.db</code> namespace.
   <li> Restart the application.
 </ol>
</div>

### Managing Your Middleware

Two middleware functions by default which are are located in the `luminus-sample.middleware` namespace.

* `log-request` - logs all requests using the debug level
* `template-error-page` - provides friendly formatting for Selmer errors in dev mode

See the `:middleware` key of the `app` definition located in the `luminus-sample.handler` namespace to manage the enabled middleware.

### Here are some links to get started

1. [HTML templating](http://www.luminusweb.net/docs/html_templating.md)
2. [Accessing the database](http://www.luminusweb.net/docs/database.md)
3. [Serving static resources](http://www.luminusweb.net/docs/static_resources.md)
4. [Setting response types](http://www.luminusweb.net/docs/responses.md)
5. [Defining routes](http://www.luminusweb.net/docs/routes.md)
6. [Adding middleware](http://www.luminusweb.net/docs/middleware.md)
7. [Sessions and cookies](http://www.luminusweb.net/docs/sessions_cookies.md)
8. [Security](http://www.luminusweb.net/docs/security.md)
9. [Deploying the application](http://www.luminusweb.net/docs/deployment.md)
