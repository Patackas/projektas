import React, { Component } from "react";
import { Route, BrowserRouter as Router, Switch } from "react-router-dom";
import HomePage from "./presentational/HomePage";
import LogInPage from "./presentational/LogInPage";
import SignUpPage from "./presentational/SignUpPage";
import CreateDocument from "./presentational/CreateDocument";
import UserBoard from "./presentational/UserBoard";
import DocumentsBoard from "./presentational/DocumentsBoard";
import GroupsListTable from "./presentational/GroupsListTable";
import GroupViewPage from "./presentational/GroupViewPage";
import CreateGroupPage from "./presentational/CreateGroupPage";
import AdministratorBord from "./presentational/AdministratorBoard";
import AdminGroupsListPage from "./presentational/AdminGroupsList";
import AdminDocumentBoard from "./presentational/AdminDocumentBoard";

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route exact path="/" component={HomePage} />
          <Route path="/prisijungti" component={LogInPage} />
          <Route path="/registruotis" component={SignUpPage} />
          <Route path="/kurtiDokumenta" component={CreateDocument} />
          <Route path="/vartotojoLangas" component={UserBoard} />
          <Route path="/manoDokumentai" component={DocumentsBoard} />
          <Route path="/grupes" component={GroupsListTable} />
          <Route path="/grupe/darbuotojai" component={GroupViewPage} />
          <Route path="/kurtigrupe" component={CreateGroupPage} />
          <Route path="/adminLangas" component={AdministratorBord} />
          <Route path="/adminGrupes" component={AdminGroupsListPage} />
          <Route path="/adminDokumentai" component={AdminDocumentBoard} />
        </Switch>
      </Router>
    );
  }
}

export default App;