#!/usr/bin/env node

const program = require('commander');
// Require logic.js file and extract controller functions using JS destructuring assignment
const { initializeProject } = require('../lib/init.js');

program
  .version('0.0.1')
  .description('Contact management system');

program
  .command('init <projectName>')
  .alias('c')
  .description('Add a contact')
  .action((projectName) => {
    initializeProject(projectName);
  });


program.parse(process.argv);

