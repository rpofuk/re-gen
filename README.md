# re-gen

Generator for initalizing re-frame web application using react, material-ui and router. 

```
npm install -g shadow-cljs # Node.js and JVM are required to be installed
```
Options
```
npx @rpofuk/re-gen --help
Usage: re-gen [options] [command]

Contact management system

Options:
  -V, --version           output the version number
  -h, --help              output usage information

Commands:
  create|c <projectName>  Bootstrap project
  add|a <pageName>        Add a page
```

```
# Create projecet
npx @rpofuk/re-gen@1.1.7 create myproject
cd myproject 

# Create new view
npx @rpofuk/re-gen@1.1.7 add demo

# Running
npm install
shadow-cljs watch app
```


Generated project has folowing structure
```

.
├── deps.edn
├── Dockerfile
├── package.json
├── package-lock.json
├── project.iml
├── resources
│   └── public
│       ├── devcards.html
│       └── index.html
├── shadow-cljs.edn
└── src
    └── main
        ├── edd
        │   ├── core.cljs
        │   ├── db.cljs
        │   ├── events.cljs
        │   ├── i18n.cljs
        │   ├── routing.cljs
        │   ├── subs.cljs
        │   ├── util.cljs
        │   └── views.cljs
        └── myproject
            ├── about
            │   ├── db.cljs
            │   ├── events.cljs
            │   ├── subs.cljs
            │   └── views.cljs
            ├── core.cljs
            ├── home
            │   ├── db.cljs
            │   ├── events.cljs
            │   ├── subs.cljs
            │   └── views.cljs
            ├── i18n.cljs
            └── styles.cljs

```

Adding new view
```
npx @rpofuk/re-gen add news

; src/main/myproject/core.cljs (dont forget required :))
; Add translations to i18n file for UX

(defn ^:export init
  [config]
  (core/init
    {...
     :panels       {...
                    :news news/main-panel}
     ...}))



```
Development

```
node bin/index.js
sudo npm install -g ./
```

During development you can use local installation: 
```
npx re-gen --help
```
