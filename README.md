<h1>lecture-18</h1>

<p>Home task lecture 18:</p>
<ol>
<li>Git repo</li>
<li>README.md file with the task and description. gitignore</li>
<li>create new maven project with 3 modules</li>
<ol>
<li>entity module</li>
<li>persistence module</li>
<li>(optional) integration test module</li>
</ol>
<li>naming: {project name}-persistence. examples: school-journal-persistence,
car-service-entity, etc</li>
<li>Create POJO classes</li>
<li>Use at least 4 class level annotations (for example embedded, immutable, and so on)</li>
<li>Use at least 5 field level annotations (for example transient)</li>
<li>Use at least 2 differ id generation strategy</li>
<li>Create your custom id generation strategy and use it</li>
<li>Create your custom name strategy and use it</li>
</ol>


<h2>What's done:</h2>
<ol>
<li>Git repo</li>
<li>Readme.md</li>
<li>created new maven project with 2 modules: entity and persistence</li>
<li>Created POJO classes</li>
<li>Used at least 4 class level annotations (for example embedded, immutable, and so on)</li>
<li>Used at least 5 field level annotations (for example transient)</li>
<li>Used at least 2 differ id generation strategy</li>
<li>Created custom id generation strategy on Good.class<</li>
<li></li>
</ol>

<h3>To run App you should:</h3>
<ol>
<li>Build project: $mvn clean install</li>
<li>Run new mysql server for the App: $docker-compose up -d</li>
<li>Run liquibase to create tables and insert data:</li>
<ol>
<li>$cd persistence/</li>
<li>then $mvn liquibase:update</li>
</ol>
<li>Run App</li>
</ol>