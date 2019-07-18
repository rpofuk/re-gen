const fs = require('fs');
const path = require("path");
var Handlebars = require("handlebars");

const CURR_DIR = process.cwd();

const initializeProject = (projectName) => {
  const templatePath = path.resolve(__dirname) + '/../templates/';
  fs.mkdirSync(`${CURR_DIR}/${projectName}`);

  createDirectoryContents(templatePath, projectName, projectName);
}
 

function createDirectoryContents (templatePath, newProjectPath, projectName) {
  const filesToCreate = fs.readdirSync(templatePath);

  filesToCreate.forEach(file => {
    const origFilePath = `${templatePath}/${file}`;
     
    // get stats about the current file
    const stats = fs.statSync(origFilePath);
    const data = {"projectName" : projectName }

    if (stats.isFile()) {
      const contents = fs.readFileSync(origFilePath, 'utf8');
      try {
          const template = Handlebars.compile(contents)
      } 
      catch (e) {
          console.log("Skipping " + file")
      }
      rendered = template(data)
      const writePath = `${CURR_DIR}/${newProjectPath}/${file}`;
      fs.writeFileSync(writePath, rendered, 'utf8');
    } else if (stats.isDirectory()) {
      const template = Handlebars.compile(file)
      targetDir = template(data)
      fs.mkdirSync(`${CURR_DIR}/${newProjectPath}/${targetDir}`);
      
      // recursive call
      createDirectoryContents(`${templatePath}/${file}`, `${newProjectPath}/${targetDir}`, projectName);
    }
  });
}

module.exports = {initializeProject};
