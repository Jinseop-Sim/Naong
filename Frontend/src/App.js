import "./App.css";
import "bootstrap/dist/css/bootstrap.css";
import * as React from "react";
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";

import Home from "./pages/home";
import InitialInfo from "./pages/initial_info/initial_info";
import Signup from "./pages/signup";
import PostSharing from "./pages/post/post_sharing";
import SharingPage from "./pages/sharing";
import DutchPayPage from "./pages/dutchpay";
import GroupBuyingPage from "./pages/groupbuying";
import Login from "./pages/login/login";
import DetailSharing from "./pages/detail/detail_sharing";
import DetailPurchase from "./pages/grouppurchase/detail_purchase";
import PostDelivery from "./pages/post/post_delivery";
import PostgroupBuying from "./pages/post/post_groupBuying";
import EditProfile from "./pages/profile/profile_edit";
import MyWriting from "./pages/myWriting";
import Layout from "./components/Layout";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/initialInfo" element={<InitialInfo />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="/detailSharing" element={<DetailSharing />} />
          <Route path="/postSharing" element={<PostSharing />} />
          <Route path="/sharing" element={<SharingPage />} />
          <Route path="/dutchPay" element={<DutchPayPage />} />
          <Route path="/groupBuying" element={<GroupBuyingPage />} />
          <Route path="/detailPurchase" element={<DetailPurchase />} />
          <Route path="/postDelivery" element={<PostDelivery />} />
          <Route path="/postGroupBuying" element={<PostgroupBuying />} />
          <Route path="/editProfile" element={<EditProfile />} />
          <Route path="/myWriting" element={<MyWriting />} />
        </Route>
      </Routes>
    </Router>
  );
}

export default App;
