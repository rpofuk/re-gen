# re-gen

Generator for initalizing re-frame web application using react, material-ui and router. 

```
npm install -g shadow-cljs # Node.js and JVM are required to be installed

# Options
npx @rpofuk/re-gen --help
Usage: re-gen [options] [command]

Contact management system

Options:
  -V, --version           output the version number
  -h, --help              output usage information

Commands:
  create|c <projectName>  Bootstrap project
  add|a <pageName>        Add a page


# Create projecet
npx @rpofuk/re-gen create myproject
cd myproject 

# Create 2 views that are assumed by project tempalte
npx @rpofuk/re-gen add home
npx @rpofuk/re-gen add about 

# Running
npm install
shadow-cljs watch app


# Generated project has folowing structure
.
├── resources
│   └── public
│       ├── devcards.html
│       └── index.html
├── src
│   └── main
│       └── myproject
│           ├── about
│           │   ├── db.cljs
│           │   ├── events.cljs
│           │   ├── subs.cljs
│           │   └── views.cljs
│           ├── home
│           │   ├── db.cljs
│           │   ├── events.cljs
│           │   ├── subs.cljs
│           │   └── views.cljs
│           ├── config.cljs
│           ├── core.cljs
│           ├── db.cljs
│           ├── events.cljs
│           ├── routes.cljs
│           ├── styles.cljs
│           ├── subs.cljs
│           ├── util.cljs
│           └── views.cljs
├── deps.edn
├── package.json
└── shadow-cljs.edn


```

Adding new view
```
npx @rpofuk/re-gen add news

# File src/main/views.cljs (dont forget required :)
(def components
  {:home  home/main-panel
   :about about/main-panel
   **:news news/main-panel**})

# File src/main/routes.cljs
(def routes ["/" {""      :home
                  "about" :about
                  **"news" :news**}])


# New page should be now reachable
http://127.0.0.1:3000/news

```
Development

```
node bin/index.js
sudo npm install -g ./
```
A
A
A

